from rpc import *
from grpc import ServicerContext
from models import BasicModel, LocalEnvironment
from typing import AsyncIterable
from utils import Properties, model_to_chunks, chunks_to_model
import logging
from threading import Lock
import time
import copy
import importlib
import torch

logger: logging = Properties.getLogger(__name__)

class TrainerService(TrainerServiceServicer):
    
    
    def __init__(self) -> None:
        super().__init__()
        self.model: BasicModel = None  # 用于训练的模型
        self.merged_model: BasicModel = None  # 只用于合并和测试的模型
        self.collected_models = dict()
        self.total_size = 0
        self.merge_lock = Lock()
        self.local_env = LocalEnvironment()
        self.ModelClass = None
        
    async def MergeModel(self, request: MergeRequest, context: ServicerContext):
        logger.info(f"leader begin to merge model")
        models = []
        # 检查是否有缺漏的模型
        for id in request.server_ids:
            model = self.collected_models.get(id, None)
            if  model is None:
                yield MergeResponse(server_id=id)
                models = []
                break
            models.append(model)
        
        if len(models) != 0:
            tick = time.time()
            with self.merge_lock:
                state = self.merged_model.merge(models, self.total_size, self.local_env)
                self.collected_models = []
                self.total_size = 0
            logger.info(f"Merging models costs {time.time() - tick} s")
            self.merged_model.eval()
            for chunk in model_to_chunks(state):
                yield MergeResponse(model_chunk=chunk)
            self.merged_model.test(self.local_env)
        
    
    async def TrainModel(self, request_iterator: AsyncIterable[TrainRequest], context: ServicerContext):
        # 多个请求到来，导致同时训练, 通过随机产生的端口来实现唯一任务的训练进程绑定，在manager端对请求加锁
        logger.info("begin to train model using local dataset")
        model_chunks = []
        async for chunk in request_iterator:
            if chunk.model_chunk is not None:  # 如果传输的是空请求， 就直接开始训练
                model_chunks.append(chunk.model_chunk)
                
        if len(model_chunks) != 0:
            self.model.load_state_dict(chunks_to_model(model_chunks))
        else:
            raise Exception("invalid model chunks")
        self.model.train()
        tick = time.time()
        self.model.local_train(self.local_env)  # 本地训练
        logger.info(f"local training costs {time.time() - tick} s")
        model_states = self.model.state_dict()
        model_states["data_size"] = self.model.data_size
        for chunk in model_to_chunks(model_states):
            yield TrainResponse(model_chunk=chunk)
        
    
    async def PushModel(self, request_iterator: AsyncIterable[PushModelRequest], context: ServicerContext):
        model_chunks = []
        model_id = 0
        async for chunk in request_iterator:
            # 其中一个块包含着 server_id
            if chunk.HasField("server_id"):
                model_id = chunk.server_id
            else:
                model_chunks.append(chunk.model_chunk)
        logger.info(f"collect model from id: {model_id}")
        model_states = chunks_to_model(model_chunks)
        for name, param in model_states.items():
            if isinstance(param, torch.Tensor):
                model_states[name] = param.to(self.local_env.device)
                
        data_size = model_states["data_size"]
        del model_states["data_size"]
        with self.merge_lock:
            self.total_size += data_size
            self.collected_models[model_id] = (model_states, data_size)
            if self.merged_model is None:
                self.merged_model = self.ModelClass()
                self.merged_model.eval()
                self.merged_model.to(self.local_env.device)
        return PushModelResponse(status=True)
    
    async def InitModel(self, request_iterator: AsyncIterable[InitModelRequest], context: ServicerContext):
        model_chunks = []
        module_name = ""
        model_name = ""
        local_epoch = None
        async for request in request_iterator:
            if request.model_chunk:
                model_chunks.append(request.model_chunk)
            else:
                model_name = request.model_class.class_name
                module_name = request.model_class.module
                local_epoch = request.model_class.local_epoch
            
        
        # self.model: BasicModel = self.model.to(self.model.device)
        try:
            TargetModelClass = getattr(importlib.import_module(module_name), model_name)
            model: BasicModel = TargetModelClass()  # 使用反射来初始化类
            model.local_num_epoch = local_epoch
            model.client_init(self.local_env)
            if len(model_chunks) != 0:
                model.load_state_dict(chunks_to_model(model_chunks))
            model.to(self.local_env.device)
            self.model = model
            self.ModelClass = TargetModelClass
        except Exception as e:
            logger.error(f"init error with {e}")
            return InitModelResponse(status=False)
        logger.info("trainer init model successfully")
        return InitModelResponse(status=True)
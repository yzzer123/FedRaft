from rpc import *
from grpc import ServicerContext
from models import BasicModel, LocalEnvironment
from typing import AsyncIterable
from utils import Properties, model_to_chunks, chunks_to_model
import logging
from threading import Lock
import time
import copy


class TrainerService(TrainerServiceServicer):
    
    logger: logging = Properties.getLogger(__name__)
    
    def __init__(self) -> None:
        super().__init__()
        self.model: BasicModel = None  # 用于训练的模型
        self.merged_model: BasicModel = None  # 只用于合并和测试的模型
        self.collected_models = dict()
        self.total_size = 0
        self.merge_lock = Lock()
        self.local_env = LocalEnvironment()
        
    async def MergeModel(self, request: MergeRequest, context: ServicerContext):
        TrainerService.logger.info(f"leader begin to merge model")
        models = []
        isBroken = False
        # 检查是否有缺漏的模型
        for id in request.server_ids:
            model = self.collected_models.get(id, None)
            if  model is None:
                yield MergeResponse(server_id=id)
                isBroken = True
                break
            models.append(model)
        
        if not isBroken:
            tick = time.time()
            with self.merge_lock:
                self.merged_model.merge(models, self.total_size, self.local_env)
                self.collected_models.clear()
                self.total_size = 0
            TrainerService.logger.info(f"Merging models costs {time.time() - tick} s")
            self.merged_model.eval()
            for chunk in model_to_chunks(self.merged_model):
                yield MergeResponse(model_chunk=chunk)
            test_log = self.merged_model.test(self.local_env)
            yield MergeResponse(model_eval_log=test_log)
        
    
    async def TrainModel(self, request_iterator: AsyncIterable[TrainRequest], context: ServicerContext):
        # 多个请求到来，导致同时训练, 通过随机产生的端口来实现唯一任务的训练进程绑定，在manager端对请求加锁
        TrainerService.logger.info("begin to train model using local dataset")
        model_chunks = []
        async for chunk in request_iterator:
            if chunk.model_chunk is not None:  # 如果传输的是空请求， 就直接开始训练
                model_chunks.append(chunk.model_chunk)
        if len(model_chunks) != 0:
            self.model = chunks_to_model(model_chunks)
        self.model.to(self.local_env.device)  # 转换张量到GPU
        self.model.train()
        tick = time.time()
        self.model.local_train(self.local_env)  # 本地训练
        TrainerService.logger.info(f"local training costs {time.time() - tick} s")

        for chunk in model_to_chunks(self.model):
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
        TrainerService.logger.info(f"collect model from id: {model_id}")
        model = chunks_to_model(model_chunks)
        model = model.to(self.local_env.device)
        model.eval()
        
        with self.merge_lock:
            self.total_size += model.data_size
            self.collected_models[model_id] = model
        return PushModelResponse(status=True)
    
    async def InitModel(self, request_iterator: AsyncIterable[InitModelRequest], context: ServicerContext):
        model_chunks = []
        async for request in request_iterator:
            model_chunks.append(request.model_chunk)
        self.merged_model = chunks_to_model(model_chunks)
        
        # self.model: BasicModel = self.model.to(self.model.device)
        try:
            self.merged_model.client_init(self.local_env)  # 测试模型是否正常 并完成初始化
            self.merged_model.to(self.local_env.device)
            self.model = copy.deepcopy(self.merged_model)
        except:
            return InitModelResponse(status=False)
        return InitModelResponse(status=True)
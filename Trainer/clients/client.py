
from rpc import ManagerServiceStub, JobSubmitRequest, JobSubmitResponse, JobConfiguration, CodeFile, ModelClass
import grpc
from models import BasicModel
import os
import random
from typing import AsyncIterator
import logging
from utils import model_to_chunks, Properties

class JobSubmitClient:
    
    logger: logging = Properties.getLogger(__name__)
    
    def __init__(self, host: str=Properties.get(Properties.MANAGER_SERVER_HOST), 
                 port: int=Properties.getInt(Properties.MANAGER_SERVER_PORT)) -> None:
        options = [('grpc.max_send_message_length', 512 * 1024 * 1024), ('grpc.max_receive_message_length', 512 * 1024 * 1024)]
        channel = grpc.aio.insecure_channel(f"{host}:{port}", options=options)
        self.stub: ManagerServiceStub = ManagerServiceStub(channel)
        
    async def _make_request(code_file_path: str, model: BasicModel) -> AsyncIterator[JobSubmitRequest]:
        file_name = os.path.split(code_file_path)[-1]
        code = None
        with open(code_file_path, "r") as file:
            code = file.read()
        
        
        code_file = CodeFile(fileName=file_name, code=code)
        model_class = ModelClass(module=model.__class__.__module__, class_name=model.__class__.__name__)
        job_conf = JobConfiguration(uuid=random.randint(999, 0x7fffffff),
                         codeFile=code_file, global_epoch=50, datasets_name="CIFAR10", model_class=model_class)
        meta_request = JobSubmitRequest(conf=job_conf)
        yield meta_request
        for chunk in model_to_chunks(model.state_dict()):
            yield JobSubmitRequest(modelChunk=chunk)

    
    async def submit(self, code_file_path: str, model: BasicModel):
        
        
        async for response in  self.stub.JobSubmit(JobSubmitClient._make_request(code_file_path, model)):
            response: JobSubmitResponse
            if response:
                JobSubmitClient.logger.info(response.logs if response.logs else f"job submit status: {response.success}")
            else:
                JobSubmitClient.logger.info("NoneType")
        
    

    
    
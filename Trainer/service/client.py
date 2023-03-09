
from rpc import ManagerServiceStub, JobSubmitRequest, JobSubmitResponse, JobConfiguration, CodeFile
import grpc
from models import BasicModel
import os
import random
from typing import AsyncIterator
import logging
from utils import model_to_chunks, Properties
import asyncio
from models.ResNet import ResNetMNIST
import sys, getopt

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
        job_conf = JobConfiguration(uuid=random.randint(999, 0x7fffffff),
                         codeFile=code_file)
        meta_request = JobSubmitRequest(conf=job_conf)
        yield meta_request
        for chunk in model_to_chunks(model):
            yield JobSubmitRequest(modelChunk=chunk)
    
    async def submit(self, code_file_path: str, model: BasicModel):
        
        
        async for response in  self.stub.JobSubmit(JobSubmitClient._make_request(code_file_path, model)):
            response: JobSubmitResponse
            if response:
                JobSubmitClient.logger.info(response.logs if response.logs else f"job submit status: {response.success}")
            else:
                JobSubmitClient.logger.info("NoneType")
        
    

if __name__ == "__main__":
    # get port from command line
    port = 12333
    try:
        opts, args = getopt.getopt(sys.argv[1:], "p:", ["port="])
        for opt, arg in opts:
            if opt in ("-p", "--port"):
                port = arg
    except getopt.GetoptError:
        print('python3 service.client -p <port>| --port <port>')
        sys.exit(2)

    loop = asyncio.get_event_loop()
    loop.run_until_complete(JobSubmitClient(port=port).submit("./models/ResNet.py", ResNetMNIST()))
    
    
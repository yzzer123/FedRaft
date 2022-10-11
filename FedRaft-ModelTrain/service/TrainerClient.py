

from concurrent.futures import ThreadPoolExecutor
from typing import Iterable
import torch
from utils import Properties
from rpc.fedraft_service_pb2_grpc import FedRaftServiceStub
import grpc
from rpc.log_message_pb2 import LogResponse, LogRequest
from utils.ModelSerializeUtils import model_to_bytes, model_to_chunks
from time import time

logger = Properties.getLogger(__name__)

class TrainerClient(object):
    """

    Args:
        object (_type_): _description_
    """
    
    def __init__(self, excutor: ThreadPoolExecutor, host: str, port: int) -> None:
        options = [('grpc.max_send_message_length', 512 * 1024 * 1024), ('grpc.max_receive_message_length', 512 * 1024 * 1024)]
        self.channel = grpc.aio.insecure_channel(f"{host}:{port}", options=options)
        self.stub = FedRaftServiceStub(self.channel)
        self._excutor = excutor
        
    
    
    def _log_request_iter(model_bytes: bytes) -> Iterable[LogRequest]:
        logger.info(f"client begin to send model chunks")    
        send_time = int(time() * 1000)
        iter_index = 0
        for chunk in model_to_chunks(model_bytes):
            logger.debug(f"sending No.{iter_index} chunk")
            yield LogRequest(leader_id=send_time, model_chunk=chunk, log_type=LogRequest.LogType.CLIENT_TO_LEADER)
        logger.info(f"client has sent all model chunks")    

        
    async def send_model_to_leader(self, model: torch.nn.Module) -> None:
        """向leader发送模型
        发送时会切为块再发送
        Args:
            model (torch.nn.Module): 要发送的目标模型
        """
        # 通过线程池实现异步回调调用
        model_bytes = model_to_bytes(model)
        response = await self.stub.AppendStreamLog(TrainerClient._log_request_iter(model_bytes))
        logger.info(f"server received model with size: {response.log_size}")    
        
        
        
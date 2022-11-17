from typing import Iterable
from beans import NodeInfo, Model
from utils import Properties
from rpc.fedraft_service_pb2_grpc import TrainerServiceStub, ManagerServiceStub
import grpc
from service import Runtime
from rpc.log_message_pb2 import LogResponse, LogRequest
from utils import model_to_bytes, model_to_chunks
from time import time

logger = Properties.getLogger(__name__)

class TrainerClient(object):
    
    
    """
    Args:
        object (_type_): _description_
    """
    
    def __init__(self, runtime: Runtime, client_id: int) -> None:
        self.node_info = NodeInfo.id_to_NodeInfo(client_id)
        address = f"{self.node_info.ip}:{self.node_info.trainer_port}"
        self.channel = grpc.aio.insecure_channel(address, options=Properties.GRPC_CLIENT_OPTIONS)
        self.stub = TrainerServiceStub(self.channel)
        self.runtime = runtime
        
    
    
    def _log_request_iter(self, model_bytes: bytes) -> Iterable[LogRequest]:
        logger.info(f"client begin to send model chunks")    
        iter_index = 0

        with self.runtime.lock:
            yield LogRequest(leader_id=self.runtime.leader_id, 
                             term=self.runtime.term, model_index=self.runtime.current_model_index,
                             log_type=LogRequest.LogType.CLIENT_TO_LEADER)
        
        
        for chunk in model_to_chunks(model_bytes):
            logger.debug(f"sending No.{iter_index} chunk")
            yield LogRequest(model_chunk=chunk)
            
        logger.info(f"client has sent all model chunks")    
    

        
    async def send_model_to_leader(self, model: Model) -> None:
        """向leader发送模型
        发送时会切为块再发送
        Args:
            model (torch.nn.Module): 要发送的目标模型
        """
        # 通过线程池实现异步回调调用
        model_bytes = model_to_bytes(model)
        response = await self.stub.AppendStreamLog(self._log_request_iter(model_bytes))
        logger.info(f"server received model with size: {response.log_size}")    
        
        
        
        
class ManagerClient(object):
    
    """
    Args:
        object (_type_): _description_
    """
    
    def __init__(self, runtime: Runtime, client_id: int) -> None:
        self.node_info = NodeInfo.id_to_NodeInfo(client_id)
        address = f"{self.node_info.ip}:{self.node_info.trainer_port}"
        self.channel = grpc.aio.insecure_channel(address, options=Properties.GRPC_CLIENT_OPTIONS)
        self.stub = ManagerServiceStub(self.channel)
        self.runtime = runtime
        
    def pull_model_from_leader(self) -> None:
        """向leader拉取模型
        TODO 后续改为向更近的节点拉取模型
        """
        # TODO pull model from leader
        pass
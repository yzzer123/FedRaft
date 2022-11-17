from rpc.fedraft_service_pb2_grpc import TrainerServiceServicer, NodeInnerContactServiceServicer
from typing import AsyncIterable
from service import Runtime
from utils import Properties
from rpc.heartbeat_message_pb2 import SyncWithTrainerRequest, SyncWithTrainerResponse
from rpc.log_message_pb2 import LogResponse, LogRequest
from utils import TimeMetric, chunks_to_model
import grpc
import time
import logging


logger = Properties.getLogger(__name__)


class TrainerService(TrainerServiceServicer):

    def __init__(self, runtime: Runtime,) -> None:
        super().__init__()
        self.runtime = runtime
    
    
    async def AppendStreamLog(self,  request_iterator: AsyncIterable[LogRequest], context: grpc.ServicerContext) -> LogResponse:
        
        chunks = []
        total_size = 0
        log_type = None
        iter_index = 0
        # timer = TimeMetric()
        
        # 接受模型切片
        async for log_msg in request_iterator:
            if log_msg.leader_id != 0:
                with self.runtime.lock:
                    if (log_msg.leader_id != self.runtime.leader_id or
                        log_msg.model_index <= self.runtime.current_model_index or
                        log_msg.term != self.runtime.term):
                        context.abort_with_status(grpc.StatusCode.INVALID_ARGUMENT)
                        return LogResponse()
                    else:
                        log_type = log_msg.log_type
            else:   
                if logger.level == logging.DEBUG:
                    logger.debug(f"get No.{iter_index} chunk")
                # send_time = log_msg.leader_id  # 用于测试性能
                chunks.append(log_msg.model_chunk)
                total_size += len(log_msg.model_chunk)
        
        model = chunks_to_model(chunks)
        
        # 判断模型流向，如果是leader接受，那么就追加到缓存中
        with self.runtime.lock:
            if log_type == LogRequest.LogType.CLIENT_TO_LEADER:
                self.runtime.models.append(model)
            else:
                self.runtime.model = model
        logger.info(f"server stored model in memory")
        
         # 计算接受模型总耗时
        # logger.info(f"server costed {timer.mark()} ms on receiving model")
        # logger.info(f"total time in sending model between client and leader: {int(timer.time_sub*1000) - send_time} ms")
        
        # 回复消息
        return LogResponse(log_size=total_size)
    
    
    
class NodeInnerContactService(NodeInnerContactServiceServicer):
    
    def __init__(self, runtime: Runtime) -> None:
        super().__init__()
        self.runtime = runtime        
    

    # manager 向 trainer 同步节点状态信息
    def SyncWithTrainer(self, request: SyncWithTrainerRequest, context):
              
        with self.runtime.lock:
            if self.runtime.timestamp < request.timestamp:
                self.runtime.term = request.term
                self.runtime.leader_id = request.leader_id
                self.runtime.node_state = request.node_state
                self.runtime.topology = list(request.node_ids)
                if self.runtime.current_model_index < request.current_model_index:
                    self.runtime.get_manager_client(self.runtime.leader_id).pull_model_from_leader()
            
            return SyncWithTrainerResponse(current_model_index=self.runtime.current_model_index
                                       , timestamp=int(time.time() * 1000))

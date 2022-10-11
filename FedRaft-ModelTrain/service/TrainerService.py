from rpc.fedraft_service_pb2_grpc import FedRaftServiceServicer
from typing import AsyncIterable
from service.NodeState import NodeState
from utils.Configuration import Properties
from rpc.log_message_pb2 import LogResponse, LogRequest
from utils.Metricsutils import TimeMetric 
from utils.ModelSerializeUtils import chunks_to_model
import grpc


logger = Properties.getLogger(__name__)


class TrainerService(FedRaftServiceServicer):
    
    async def AppendLog(self, request, context):
        
        return super().AppendLog(request, context)
    
    async def AppendStreamLog(self, request_iterator: AsyncIterable[LogRequest], context: grpc.ServicerContext) -> LogResponse:
        
        chunks = []
        total_size = 0
        log_type = None
        iter_index = 0
        send_time = 0  # 用于测试性能
        timer = TimeMetric()
        
        # 接受模型切片
        async for log_msg in request_iterator:
            logger.debug(f"get No.{iter_index} chunk")
            log_type = log_msg.log_type
            send_time = log_msg.leader_id  # 用于测试性能
            chunks.append(log_msg.model_chunk)
            total_size += len(log_msg.model_chunk)
        
        model = chunks_to_model(chunks)
        node = NodeState.node_state
        
        # 判断模型流向，如果是leader接受，那么就追加到缓存中
        if log_type == LogRequest.LogType.CLIENT_TO_LEADER:
            node.models.append(model)
        else:
            node.model = model
        logger.info(f"server stored model in memory")
        
         # 计算接受模型总耗时
        logger.info(f"server costed {timer.mark()} ms on receiving model")
        logger.info(f"total time in sending model between client and leader: {int(timer.time_sub*1000) - send_time} ms")
        
        # 回复消息
        return LogResponse(log_size=total_size)
    
    def Heartbeat(self, request, context: grpc.ServicerContext):
        return super().Heartbeat(request, context)
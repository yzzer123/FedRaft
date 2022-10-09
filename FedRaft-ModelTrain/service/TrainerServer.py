import grpc
from concurrent import futures
from rpc import fedraft_service_pb2_grpc
from service.NodeState import NodeState
from service.TrainerService import TrainerService
from utils.Configuration import Properties

logger = Properties.getLogger(__name__)

class TrainerServer(object):
    
    
    def __init__(self) -> None:
        options = [('grpc.max_send_message_length', 512 * 1024 * 1024), ('grpc.max_receive_message_length', 512 * 1024 * 1024)]
        self.server = grpc.aio.server(futures.ThreadPoolExecutor(max_workers=Properties.getInt(Properties.TRAINER_SERVER_THREADS)),
                                      options=options)
        # 注册grpc服务
        fedraft_service_pb2_grpc.add_FedRaftServiceServicer_to_server(TrainerService(), self.server)
        self.server.add_insecure_port("[::]:" + str(Properties.getInt(Properties.TRAINER_SERVER_PORT)))

    
    def init(self) -> None:
        NodeState.node_state = NodeState()
    
    
    async def start(self) -> None:
        await self.server.start()
        logger.info("rpc server start on port: " + Properties.get(Properties.TRAINER_SERVER_PORT))
        self.init()
        
        
        
    async def blockingUtilShudown(self) -> None:
        try:
            await self.server.wait_for_termination()
        except KeyboardInterrupt:
            # Shuts down the server with 0 seconds of grace period. During the
            # grace period, the server won't accept new connections and allow
            # existing RPCs to continue within the grace period.
            await self.server.stop(2.)
        
        
        



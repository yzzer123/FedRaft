import grpc
from concurrent import futures
from rpc import trainer_service_pb2_grpc
from .services import TrainerService
from utils import Properties
import logging

class TrainerServer(object):
    
    logger: logging = Properties.getLogger(__name__)
    
    def __init__(self, port: int=None) -> None:
        self.port = port if port != None else Properties.getInt(Properties.TRAINER_SERVER_PORT)


        options = [('grpc.max_send_message_length', 512 * 1024 * 1024), ('grpc.max_receive_message_length', 512 * 1024 * 1024)]
        self.server = grpc.aio.server(futures.ThreadPoolExecutor(max_workers=Properties.getInt(Properties.TRAINER_SERVER_THREADS)),
                                        options=options)
        
        # 注册grpc服务
        trainer_service_pb2_grpc.add_TrainerServiceServicer_to_server(TrainerService(), self.server)
        self.server.add_insecure_port("[::]:" + str(self.port))

    def init(self) -> None:
        pass
    
    
    async def start(self) -> None:
        await self.server.start()
        TrainerServer.logger.info(f"trainer server start on port: {self.port}")
        self.init()
        
        
        
    async def blockingUtilShutdown(self) -> None:
        try:
            await self.server.wait_for_termination()
        except KeyboardInterrupt:
            # Shuts down the server with 0 seconds of grace period. During the
            # grace period, the server won't accept new connections and allow
            # existing RPCs to continue within the grace period.
            await self.server.stop(2.)
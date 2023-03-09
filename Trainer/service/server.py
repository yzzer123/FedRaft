import grpc
from concurrent import futures
from rpc import trainer_service_pb2_grpc
from .services import TrainerService
from utils import Properties
import logging
import asyncio
import sys, getopt



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
            


async def main(port:int=None):
    trainer_server = TrainerServer(port)
    await trainer_server.start()

    await trainer_server.blockingUtilShutdown()


if __name__ == "__main__":

    # get port from command line
    port = None
    try:
        opts, args = getopt.getopt(sys.argv[1:], "p:", ["port="])
        for opt, arg in opts:
            if opt in ("-p", "--port"):
                port = arg
    except getopt.GetoptError:
        print('main.py -p <port>| --port <port>')
        sys.exit(2)

    loop = asyncio.get_event_loop()
    loop.run_until_complete(main(port))
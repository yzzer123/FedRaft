import asyncio
from utils import Properties
from service.TrainerServer import TrainerServer

async def main():
    trainer_server = TrainerServer()
    await trainer_server.start()
    
    await trainer_server.blockingUtilShudown()

if __name__=="__main__":
    asyncio.run(main())
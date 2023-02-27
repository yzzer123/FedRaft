import asyncio
from service import TrainerServer
import sys, getopt


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


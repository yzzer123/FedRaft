from clients import JobSubmitClient
from models import ResNetMNIST
import getopt
import sys
import asyncio

if __name__ == "__main__":
    # get port from command line
    port = 19670
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
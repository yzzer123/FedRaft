from service import JobSubmitClient
import asyncio
from models.ResNet import ResNetMNIST
import time


if __name__ == "__main__":
    loop = asyncio.get_event_loop()
    
    loop.run_until_complete(JobSubmitClient(port=12333).submit("./models/ResNet.py", ResNetMNIST()))
    
    
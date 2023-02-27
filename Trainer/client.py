from service import JobSubmitClient
import asyncio
from models.ResNet import ResNetMNIST



if __name__ == "__main__":
    loop = asyncio.get_event_loop()
    
    loop.run_until_complete(JobSubmitClient().submit("./models/ResNet.py", ResNetMNIST()))
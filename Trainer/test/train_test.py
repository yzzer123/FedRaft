from service import TrainerService
from models import ResNetCIFAR10
from utils import *
from rpc import *
import asyncio

async def make_list_async(list):
    for item in list:
        yield item

async def async_main():
    instance_num = 5
    ids = [i for i in range(instance_num)]
    services = [TrainerService() for i in range(instance_num)]
    model = ResNetCIFAR10()
    global_epoch = 10
    init_requests = [InitModelRequest(model_class=ModelClass(module=ResNetCIFAR10.__module__,
                                                             class_name=ResNetCIFAR10.__name__,
                                                             local_epoch=3))]
    
    for chunk in model_to_chunks(model.state_dict()):
        init_requests.append(InitModelRequest(model_chunk=chunk))
    
    
    tasks = [service.InitModel(make_list_async(init_requests), None) for service in services]
    
    await asyncio.gather(*tasks)
    
    train_requests = [TrainRequest(model_chunk=chunk) for chunk in model_to_chunks(model.state_dict())]
    
    
    for i in range(global_epoch):
        print(f"global epoch {i}")
        leader_id = i % instance_num
        
        
        # 分发模型 + 本地训练
        for i, service in enumerate(services, 0):
            push_requests = [PushModelRequest(model_chunk=chunk.model_chunk) async for chunk in service.TrainModel(make_list_async(train_requests), None)]
            push_requests.append(PushModelRequest(server_id=i))
            response = await services[leader_id].PushModel(make_list_async(push_requests), None)
            print(f"response: {response.status}")


        # 合并模型
        request = MergeRequest()
        request.server_ids[:] = ids
        
        train_requests = [] 
        async for chunk in services[leader_id].MergeModel(request, None):
            chunk: MergeResponse
            
            train_requests.append(TrainRequest(model_chunk=chunk.model_chunk))
                
        
                

def main():
    loop = asyncio.get_event_loop()
    loop.run_until_complete(async_main())
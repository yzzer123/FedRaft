from service import TrainerService
from models import ResNetMNIST
from utils import *
from rpc import *


def main():
    instance_num = 5
    ids = [i for i in range(instance_num)]
    services = [TrainerService() for i in range(instance_num)]
    model = ResNetMNIST(5)   
    global_epoch = 15
    chunks = list(map(lambda x: InitModelRequest(model_chunk=x), model_to_chunks(model)))
    
    # 初始化
    for service in services:
        response = service.InitModel(chunks, None)
        print(f"response: {response.status}")
        
    chunks = list(map(lambda x: TrainRequest(model_chunk=x), model_to_chunks(model)))
    
    for i in range(global_epoch):
        print(f"global epoch {i}")
        leader_id = i % instance_num
        
        # 分发模型 + 本地训练
        for i, service in enumerate(services, 0):
            model_chunks = [PushModelRequest(model_chunk=chunk.model_chunk) for chunk in service.TrainModel(chunks, None)]
            model_chunks.append(PushModelRequest(server_id=i))
            response = services[leader_id].PushModel(model_chunks, None)
            print(f"response: {response.status}")


        # 合并模型
        request = MergeRequest()
        request.server_ids[:] = ids
        
        chunks.clear() 
        for chunk in services[leader_id].MergeModel(request, None):
            chunk: MergeResponse
            if chunk.HasField("model_eval_log"):
                print(chunk.model_eval_log)
            else:
                chunks.append(TrainRequest(model_chunk=chunk.model_chunk))
                
        
        
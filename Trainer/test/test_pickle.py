from test.pickle_model import Dog
import pickle
from models import ResNetMNIST
from utils import model_to_chunks, chunks_to_model
import time
import torch
import copy


def obj_test():
    
    a_dog = Dog("yzer")

    str = pickle.dumps(a_dog)
    print(str)


    # pickle的序列化对象必须在有该对象代码的机器上才可以运行
    # str = b'\x80\x04\x95-\x00\x00\x00\x00\x00\x00\x00\x8c\x0cpickle_model\x94\x8c\x03Dog\x94\x93\x94)\x81\x94}\x94\x8c\x04name\x94\x8c\x04yzer\x94sb.'
    obj = pickle.loads(str)
    obj.greet()
    print(obj.__module__)
    
def performace_test():
    model = ResNetMNIST(10, 10)
    tick = time.time()
    [model_to_chunks(model) for i in range(1000000)]
    print(f"\n\ncost {time.time() - tick}")
    
    tick = time.time()
    [model_to_chunks(model.state_dict()) for i in range(1000000)]
    print(f"\n\ncost {time.time() - tick}")
    
    tick = time.time()
    [copy.deepcopy(model) for i in range(1)]
    print(f"cost {time.time() - tick} s")
    
    
def test_model():
    model = ResNetMNIST(10)
    for param in model.parameters():
        # param: torch.nn.parameter.Parameter
        # with torch.no_grad():
        #     param[:] = param.cuda() / 2 
        # print(type(param))
        pass

if __name__ == "__main__":
    obj_test()
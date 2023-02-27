from torch import nn
from torch.utils.data import Dataset, DataLoader
from abc import abstractmethod
import torch
from typing import Tuple, List, OrderedDict


class LocalEnvironment(object):
    
    def __init__(self) -> None:
        self.train_loader, self.test_loader = None, None
        self.device = None


class BasicModel(nn.Module):
    
    def __init__(self, local_num_epoch=5) -> None:
        super().__init__()
        # 初始化时放置全局超参
        self.local_num_epoch = local_num_epoch
        self.data_size = 0        
        
    def merge(self, models: List[nn.Module], total_data_size: int, env: LocalEnvironment) -> nn.Module:
        """
            默认FedAvg根据数据量加权平均 平均后覆盖到自己的参数中
        """  
        params = [torch.zeros(param.shape).to(env.device) for param in self.parameters()]
        
        with torch.no_grad():
            for model in models:
                weight = torch.tensor(model.data_size/total_data_size).to(env.device)
                for i, param in enumerate(model.parameters(), 0):
                    params[i] += (weight * param)
            
            for i, param in enumerate(self.parameters()):
                param[:] = params[i]
                                   
        return self
        
   
    def client_init(self, env: LocalEnvironment):
        """
            完成第一次的模型初始化, 在这里可以定制每台机器上的
        """
        env.train_loader, env.test_loader = self.get_dataloader()
        env.device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

        
    @abstractmethod
    def get_dataloader(self) -> Tuple[DataLoader]:
        # 返回训练集和测试集
        return None, None
    
    @abstractmethod
    def local_train(self, env: LocalEnvironment) -> int:
        """
            本地训练，需要返回参与训练的数据集大小
        """
        return 0
    
    @abstractmethod
    def test(self, env: LocalEnvironment):
        """
            对leader汇总的模型进行测试
        """
        pass
    
    @abstractmethod
    def save(self):
        """
            备用, 用于保存的模型
        """
        pass
 
 
    
    
        

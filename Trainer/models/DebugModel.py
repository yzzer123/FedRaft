from models import BasicModel, LocalEnvironment
from torch.utils.data import DataLoader
import time
from typing import Tuple

import logging

class DebugModel(BasicModel):
    
    def __init__(self, local_num_epoch=5) -> None:
        super().__init__(local_num_epoch)
        self.logger = logging.getLogger(DebugModel.__name__)
        
    
    def forward(self, x):
        return 0
    
    def get_dataloader(self) -> Tuple[DataLoader]:
        # 分别返回训练集DataLoader和测试集DataLoader
        return None, None
    
    def local_train(self, env: LocalEnvironment):
        for i in range(self.local_num_epoch):
            self.logger.info(f"local training in {i} epoch")
            time.sleep(5.)
            
    
    def test(self, env: LocalEnvironment):
        self.logger.info(f"model acc : {60} %")
        
    
        
        
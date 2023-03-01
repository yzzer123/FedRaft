
from models import BasicModel, LocalEnvironment
from torch.utils.data import DataLoader
from typing import Tuple 
from torchvision import datasets,transforms
import torch
import torch.nn.functional as F
from utils import Properties
import logging


logger: logging = Properties.getLogger(__name__)

#模块搭建
class ResBlock(torch.nn.Module):
    def __init__(self,channels_in):
        super().__init__()
        self.conv1=torch.nn.Conv2d(channels_in,30,5,padding=2)
        self.conv2=torch.nn.Conv2d(30,channels_in,3,padding=1)

    def forward(self,x):
        out=self.conv1(x)
        out=self.conv2(out)
        return F.relu(out+x)

class ResNetMNIST(BasicModel):
    
    def __init__(self, local_num_epoch=5) -> None:
        super().__init__(local_num_epoch)
        self.conv1=torch.nn.Conv2d(1,20,5)
        self.conv2=torch.nn.Conv2d(20,15,3)
        self.maxpool=torch.nn.MaxPool2d(2)
        self.resblock1=ResBlock(channels_in=20)
        self.resblock2=ResBlock(channels_in=15)
        self.full_c=torch.nn.Linear(375,10)

    def client_init(self, env: LocalEnvironment):
        super().client_init(env)
        env.device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
        logger.info("client inited")
        
        
    def forward(self, x):
        size=x.shape[0]
        x=F.relu(self.maxpool(self.conv1(x)))
        x=self.resblock1(x)
        x=F.relu(self.maxpool(self.conv2(x)))
        x=self.resblock2(x)
        x=x.view(size,-1)
        x=self.full_c(x)
        return x
        
        
    def get_dataloader(self) -> Tuple[DataLoader]:
        batch = 100
        trans=transforms.Compose([transforms.ToTensor(),transforms.Normalize(0.15,0.30)])
        train_set=datasets.MNIST("~/datasets/MNIST",train=True,download=True,transform=trans)
        train_loader=DataLoader(train_set,batch_size=batch,shuffle=True,num_workers=4)
        test_set=datasets.MNIST("~/datasets/MNIST", train=False,download=True,transform=trans)
        test_loader=DataLoader(test_set,batch_size=batch,num_workers=4)
        return train_loader, test_loader

    
    def local_train(self, env: LocalEnvironment):
        criterion=torch.nn.CrossEntropyLoss()
        optimizer=torch.optim.Adam(self.parameters(),lr=0.005)
        scheduler=torch.optim.lr_scheduler.ExponentialLR(optimizer,gamma=0.999)
        data_size = 0
        for epoch in range(self.local_num_epoch):
            for batch_index,data in enumerate(env.train_loader,0):
                l=0.0
                data_size += len(data)
                train_data,train_labels=data
                train_data, train_labels = train_data.to(env.device), train_labels.to(env.device)
                optimizer.zero_grad()
                pred_data=self.forward(train_data)
                loss=criterion(pred_data,train_labels)
                loss.backward()
                l+=loss.item()
                optimizer.step()
                scheduler.step()
                if batch_index%100==0:
                    logger.info("epoch:",epoch,"batch_index:",batch_index/100,"loss:",l)
        self.data_size =data_size
    
    
    def test(self, env: LocalEnvironment):

        eval_msg = ""
        with torch.no_grad():
            correct=0.0
            total=0.0
            for batch_index,data in enumerate(env.test_loader,0):
                test_data,test_labels=data
                test_data, test_labels = test_data.to(env.device), test_labels.to(env.device)
                pred_data=self.forward(test_data)
                _,pred_labels=torch.max(pred_data,dim=1)
                total+=test_labels.shape[0]
                correct+=(pred_labels==test_labels).sum().item()
                if batch_index%10==0:
                    eval_msg += f"测试进度: {100.0*batch_index/100} %\n"
            eval_msg += f"准确率为: {correct*100.0/total} %\n"
        logger.info(eval_msg)
    
    def save(self):
        
        return super().save()
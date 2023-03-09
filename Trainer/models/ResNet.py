
from models import BasicModel, LocalEnvironment
from torch.utils.data import DataLoader, Subset
from typing import Tuple 
from torchvision import datasets,transforms
from torchvision.models import resnet18
import torch
import torch.nn.functional as F
from utils import Properties
import logging
from torch import nn
import os

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
        super().__init__()
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
        train_set=datasets.MNIST("/home/zzz/datasets/MNIST",train=True,download=True,transform=trans)
        train_loader=DataLoader(train_set,batch_size=batch,shuffle=True,num_workers=4)
        test_set=datasets.MNIST("/home/zzz/datasets/MNIST", train=False,download=True,transform=trans)
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
        self.data_size = data_size
    
    
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
            eval_msg += f"准确率为: {correct*100.0/total} %\n"
        return eval_msg
    
    def save(self):
        
        return super().save()

class BasicBlock(nn.Module):
	expansion = 1
	def __init__(self, in_planes, planes, stride=1): #初始化函数，in_planes为输入通道数，planes为输出通道数，步长默认为1
		super(BasicBlock, self).__init__()
        #定义第一个卷积，默认卷积前后图像大小不变但可修改stride使其变化，通道可能改变
		self.conv1 = nn.Conv2d(in_planes, planes, kernel_size=3, stride=stride, 				padding=1, bias=False)
        #定义第一个批归一化
		self.bn1 = nn.BatchNorm2d(planes)
        #定义第二个卷积，卷积前后图像大小不变，通道数不变
		self.conv2 = nn.Conv2d(planes, planes, kernel_size=3,stride=1, padding=1, bias=False)
        #定义第二个批归一化
		self.bn2 = nn.BatchNorm2d(planes)
        #定义一条捷径，若两个卷积前后的图像尺寸有变化(stride不为1导致图像大小变化或通道数改变)，捷径通过1×1卷积用stride修改大小
        #以及用expansion修改通道数，以便于捷径输出和两个卷积的输出尺寸匹配相加
		self.shortcut = nn.Sequential()
		if stride != 1 or in_planes != self.expansion*planes:
			self.shortcut = nn.Sequential(
				nn.Conv2d(in_planes, self.expansion*planes,kernel_size=1, stride=stride, bias=False),
				nn.BatchNorm2d(self.expansion*planes)
			)
        #定义前向传播函数，输入图像为x，输出图像为out
        
	def forward(self, x):
		out = F.relu(self.bn1(self.conv1(x))) #第一个卷积和第一个批归一化后用ReLU函数激活
		out = self.bn2(self.conv2(out))
		out += self.shortcut(x) #第二个卷积和第二个批归一化后与捷径相加
		out = F.relu(out) #两个卷积路径输出与捷径输出相加后用ReLU激活
		return out


    

class ResNetCIFAR10(BasicModel):
    
    def __init__(self) -> None:
        super().__init__()
        
        #设置第一层的输入通道数
        self.in_planes = 64
        block = BasicBlock
        num_blocks = [2, 2, 2, 2]
        num_classes = 10
        #定义输入图片先进行一次卷积与批归一化，使图像大小不变，通道数由3变为64得两个操作
        self.conv1 = nn.Conv2d(3, 64, kernel_size=3,stride=1, padding=1, bias=False)
        self.bn1 = nn.BatchNorm2d(64)
        #定义第一层，输入通道数64，有num_blocks[0]个残差块，残差块中第一个卷积步长自定义为1
        self.layer1 = self._make_layer(block, 64, num_blocks[0], stride=1)
        #定义第二层，输入通道数128，有num_blocks[1]个残差块，残差块中第一个卷积步长自定义为2
        self.layer2 = self._make_layer(block, 128, num_blocks[1], stride=2)
        #定义第三层，输入通道数256，有num_blocks[2]个残差块，残差块中第一个卷积步长自定义为2
        self.layer3 = self._make_layer(block, 256, num_blocks[2], stride=2)
        #定义第四层，输入通道数512，有num_blocks[3]个残差块，残差块中第一个卷积步长自定义为2
        self.layer4 = self._make_layer(block, 512, num_blocks[3], stride=2)
        #定义全连接层，输入512*block.expansion个神经元，输出10个分类神经元
        self.linear = nn.Linear(512*block.expansion, num_classes)
        #定义创造层的函数，在同一层中通道数相同，输入参数为残差块，通道数，残差块数量，步长
    def _make_layer(self, block, planes, num_blocks, stride):
        #strides列表第一个元素stride表示第一个残差块第一个卷积步长，其余元素表示其他残差块第一个卷积步长为1
        strides = [stride] + [1]*(num_blocks-1)
        #创建一个空列表用于放置层
        layers = []
        #遍历strides列表，对本层不同的残差块设置不同的stride
        for stride in strides:
            layers.append(block(self.in_planes, planes, stride)) #创建残差块添加进本层
            self.in_planes = planes * block.expansion #更新本层下一个残差块的输入通道数或本层遍历结束后作为下一层的输入通道数
        return nn.Sequential(*layers) #返回层列表
        #定义前向传播函数，输入图像为x，输出预测数据
    def forward(self, x):
        out = F.relu(self.bn1(self.conv1(x))) #第一个卷积和第一个批归一化后用ReLU函数激活
        out = self.layer1(out) #第一层传播
        out = self.layer2(out) #第二层传播
        out = self.layer3(out) #第三层传播
        out = self.layer4(out) #第四层传播
        out = F.avg_pool2d(out, 4) #经过一次4×4的平均池化
        out = out.view(out.size(0), -1) #将数据flatten平坦化
        out = self.linear(out) #全连接传播
        return out


    def client_init(self, env: LocalEnvironment):
        super().client_init(env)
        env.device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
        logger.info("client inited")
        
        
        
        
    def get_dataloader(self) -> Tuple[DataLoader]:
        batch = 128
        
        torch.manual_seed(123)
        #图像预处理变换的定义
        transform_train = transforms.Compose([
        transforms.RandomCrop(32, padding=4), #在一个随机的位置进行裁剪，32正方形裁剪，每个边框上填充4
        transforms.RandomHorizontalFlip(), #以给定的概率随机水平翻转给定的PIL图像，默认值为0.5
        transforms.ToTensor(), #将PIL Image或者 ndarray 转换为tensor，并且归一化至[0-1]
        transforms.Normalize((0.4914, 0.4822, 0.4465), (0.2023, 0.1994, 0.2010)),#用平均值和标准偏差归一化张量图像，
        #(M1,…,Mn)和(S1,…,Sn)将标准化输入的每个通道
        ])
        transform_test = transforms.Compose([ #测试集同样进行图像预处理
        transforms.ToTensor(),
        transforms.Normalize((0.4914, 0.4822, 0.4465), (0.2023, 0.1994, 0.2010)),
        ])

        train_dataset = datasets.CIFAR10("/home/zzz/datasets/cifar10", train=True, download=True, transform=transform_train)
        eval_dataset = datasets.CIFAR10("/home/zzz/datasets/cifar10", train=False, transform=transform_test)
        
        if "FL_SLICE_INDEX" in os.environ:
            index, step = os.environ["FL_SLICE_INDEX"].split(":")
            index, step = int(index), int(step)
            train_dataset = Subset(train_dataset, list(range(index, len(train_dataset), step)))
        
        train_loader=DataLoader(train_dataset,batch_size=batch, shuffle=True,num_workers=4)
        test_loader=DataLoader(eval_dataset,batch_size=batch, num_workers=2)
        return train_loader, test_loader

    
    def local_train(self, env: LocalEnvironment):
        lr = 1e-2
        optimizer = torch.optim.Adam(self.parameters(), lr=lr)
        loss = torch.nn.CrossEntropyLoss() #损失函数loss使用交叉熵损失函数
        batch_count = 0 #批量计数器设为0
        self.data_size = 0
        for epoch in range(self.local_num_epoch):#循环训练回合，每回合会以批量为单位训练完整个训练集，一共训练num_epochs个回合
		#每一训练回合初始化累计训练损失函数为0.0，累计训练正确样本数为0.0，训练样本总数为0，start为开始计时的时间点
            train_l_sum, data_size = 0.0, 0
            for X, y in env.train_loader: #循环每次取一批量的图像与标签
                X = X.to(env.device) #将图像搬移至指定设备上
                y = y.to(env.device) #将标签搬移至指定设备上
                y_hat = self(X) #将批量图像数据X输入网络模型net，得到输出批量预测数据y_hat
                l = loss(y_hat, y) #计算批量预测标签y_hat与批量真实标签y之间的损失函数l
                optimizer.zero_grad() #优化器的梯度清零
                l.backward() #对批量损失函数l进行反向传播计算梯度
                optimizer.step() #优化器的梯度进行更新，训练所得参数也更新
                train_l_sum += l.cpu().item() #将本批量损失函数l加至训练损失函数累计train_l_sum中
                data_size += y.shape[0] #将本批量训练的样本数，加至训练样本总数
                batch_count += 1 #批量计数器加1
            # test_acc = self.test(env)#对本回合训练所得网络模型参数，以批量为单位，测试全集去验证，得到测试集预测准确度
            logger.info('epoch %d, loss %.5f' % (epoch + 1, train_l_sum / batch_count))
            self.data_size += data_size

        
    
    def test(self, env: LocalEnvironment):

        #累计正确样本设为0.0，累计预测样本数设为0
        acc_sum, n = 0.0, 0
        #准确度评估阶段，with torch.no_grad()封装内关闭梯度计算功能
        with torch.no_grad():
            #从数据加载器上批量读取数据X与标签y
            for X, y in env.test_loader:
                    #判断net(X.to(device)).argmax(dim=1)即X经net后输出的批量预测列表中每一个样本输出的最大值和y.to(device)此样本真实标签是否相同，
                    #若相同则表示预测正确，等号表达式为True，值为1；否则表达式为False，值为0。将批量所有样本的等号表达式值求和后再加给acc_sum
                    #每一次acc_sum增加一批量中预测正确的样本个数，随着不断的遍历，acc_sum表示累计的所有预测正确的样本个数
                acc_sum += (self(X.to(env.device)).argmax(dim=1) == y.to(env.device)).float().sum().cpu().item()
                n += y.shape[0] #每一次y.shape[0]表示一批量中标签个数，也就是样本个数。所以n表示累计的所有预测过的样本个数，无论正确与否
        logger.info('accracy = %.5f' % (acc_sum / n))
        #用累计的所有预测正确的样本个数除以累计的所有预测过的样本个数得到准确率


    def save(self):
        
        return super().save()
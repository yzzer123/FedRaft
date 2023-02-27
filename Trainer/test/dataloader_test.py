from torch.utils.data import Dataset, DataLoader
import torch

class MyDataset(Dataset):
    def __init__(self, size):
        self.x = torch.randn(size, 1)
    
    def __getitem__(self, index):
        return self.x[index]
 
    def __len__(self):
        return len(self.x)
 
dataset = MyDataset(1001)
 
data_loader = DataLoader(dataset,
                         batch_size=10)
 
print(len(data_loader))
 
for batch_idx, data in enumerate(data_loader):
    print('batch idx{}, batch len {}'.format(
        batch_idx, len(data)))
 
data_loader = DataLoader(dataset,
                     batch_size=10,
                     drop_last=True)
 
print(len(data_loader))
 
for batch_idx, data in enumerate(data_loader):
    print('batch idx{}, batch len {}'.format(
        batch_idx, len(data)))
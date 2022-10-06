
from typing import Iterator,List
from torch import nn
from .Configuration import Properties
import pickle
from math import ceil
import torch

def model_to_chunks(model: nn.Module, chunk_size=Properties.getInt(Properties.LOG_MODEL_CHUNKSIZE)) -> Iterator[bytes]:
    """_summary_

    Args:
        model (nn.Module): 目标模型
        chunk_size (_type_, optional): 切块后每一块字节数组的大小. Defaults to Properties.LOG_MODEL_CHUNKSIZE.

    Yields:
        Iterator[bytes]: 返回一个迭代器，每次返回一个字节块
    """
    model_bytes = pickle.dumps(model)
    
    
    # 计算切块数量，向上取整
    model_size = len(model_bytes)
    num_chunk = ceil(model_size / chunk_size)
    
    for i in range(num_chunk):
        chunk = model_bytes[i * chunk_size: min((i + 1) * chunk_size, model_size)]
        yield chunk
    
def chunks_to_model(chunks: List[bytes]) -> nn.Module:
    """_summary_

    Args:
        bytes_data (bytes): 模型的序列化字节

    Returns:
        nn.Module: 反序列化得到的模型
    """
    bytes_data = b''.join(chunks)
    model = pickle.loads(bytes_data)  
    return model
import pickle
from math import ceil
from models import BasicModel
from typing import Iterator, List

from .Configuration import Properties

logger = Properties.getLogger(name=str(__name__))


def model_to_bytes(model: BasicModel) -> bytes:
    """模型序列化

    Args:
        model (nn.Module): 模型

    Returns:
        bytes: 序列化后的字节属数组
    """
    model_bytes = pickle.dumps(model)
    logger.debug(f"model_to_chunks: model has been serialized, size: {len(model_bytes)/1024} KB")
    return model_bytes


def model_to_chunks(model, chunk_size=Properties.getInt(Properties.LOG_MODEL_CHUNK_SIZE)) -> Iterator[
    bytes]:
    """字节序列切片

    Args:
        model_bytes (bytes): 目标模型序列化后的字节
        chunk_size (_type_, optional): 切块后每一块字节数组的大小. Defaults to Properties.LOG_MODEL_CHUNKSIZE.

    Yields:
        Iterator[bytes]: 返回一个迭代器，每次返回一个字节块
    """
    
    model_bytes = model_to_bytes(model)

    # 计算切块数量，向上取整
    model_size = len(model_bytes)
    num_chunk = ceil(model_size / chunk_size)

    for i in range(num_chunk):
        # logger.debug(f"model_to_chunks:  {i}th chunk of model has been returned")
        chunk = model_bytes[i * chunk_size: min((i + 1) * chunk_size, model_size)]
        yield chunk


def chunks_to_model(chunks: List[bytes]) -> BasicModel:
    """_summary_

    Args:
        bytes_data (bytes): 模型的序列化字节

    Returns:
        nn.Module: 反序列化得到的模型
    """
    bytes_data = b''.join(chunks)
    logger.debug("chunks_to_model: combine bytes chunks to model bytes")

    model = pickle.loads(bytes_data)
    logger.debug("chunks_to_model: model loaded")
    return model

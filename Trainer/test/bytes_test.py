"""
    用于测试序列化性能
"""
import time

def merge3(chunk: bytes):
    arr = bytearray()
    for i in  range(100):
        arr.extend(chunk)
        
    return bytes(arr)   

def merge2(chunk: bytes):
    
    chunks = []
    
    for i in  range(100):
        chunks.append(chunk)        
    return b''.join(chunks)


def merge1(chunk: bytes):
    
    merged = b''
    
    for i in  range(100):
        merged += chunk
        
    return merged


def main():
    chunk = b'1' * 7340032

    
    tick1 = time.time()
    merge2(chunk)
    print(time.time() - tick1)
    
    tick1 = time.time()
    merge3(chunk)
    print(time.time() - tick1)
    
    
    
    pass
    

if __name__ == "__main__":
    a = main()
    print(a)

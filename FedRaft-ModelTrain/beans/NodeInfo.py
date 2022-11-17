
from functools import reduce

class NodeInfo(object):
    
    E16 = 1 << 16
    E8 = 1 << 8
    
    def __init__(self, ip: str, manager_port: int, trainer_port: int) -> None:
        self.ip = ip
        self.manager_port = manager_port
        self.trainer_port = trainer_port
        
    def get_id(self) -> int:
        
        fields = self.ip.split(".")
        
        node_id = reduce(lambda x, y: (x << 8) + int(y), fields, 0)
        node_id = (node_id << 32) + (self.manager_port << 16) + self.trainer_port
        
        return node_id
        
        
    def __str__(self) -> str:
        return f"NodeInfo[{self.ip}:{self.manager_port}:{self.trainer_port}]"
    
    @classmethod
    def id_to_NodeInfo(cls, id: int):
        fields = [i for i in range(4)]
        trainer_port = id % NodeInfo.E16
        id >>= 16
        manager_port = id % NodeInfo.E16
        id >>= 16
        for i in range(4):
            fields[3 - i] = str(id % NodeInfo.E8)
            id >>= 8
            
        return NodeInfo(".".join(fields), manager_port, trainer_port)
        
        
    @classmethod
    def id_to_ip(cls, id: int) -> str:
        fields = [i for i in range(4)]
        id >>= 32
        for i in range(4):
            fields[3 - i] = str(id % NodeInfo.E8)
            id >>= 8
        return ".".join(fields)
        
    @classmethod
    def id_to_manager_port(cls, id: int) -> int:
        return (id >> 16) % NodeInfo.E16
    
    @classmethod
    def id_to_trainer_port(cls, id: int) -> int:
        return id % NodeInfo.E16
    


from concurrent.futures import ThreadPoolExecutor
from threading import RLock
from .Client import TrainerClient, ManagerClient
from utils import Properties
from rpc.heartbeat_message_pb2 import NodeState
logger = Properties.getLogger(__name__)


class Runtime(object):
    """_summary_
        节点状态信息，包括通信连接池、节点角色等信息
    """
    
    node_state = None
    
    def __init__(self) -> None:
        
        self.lock = RLock()
        
        self.term = -1  # 任期
        self.leader_id = -1  # leader的ID号
        self.current_model_index = -1  # 目前
        self.node_state = NodeState.SAFE_MODE
        self.topology = []   # 拓扑
        self.timestamp = 0  # 内容时间戳
        self.clients_pool = {}  # 连接池
        self.term = 0  # 任期
        self.model = None  # 模型
        self.models = []  # 汇总模型的列表
        self.clients_pool = {}  # 用于通信的客户端
        self.__excutor = ThreadPoolExecutor(max_workers=Properties.getInt(Properties.TRAINER_CLIENT_THREADS))

    
    def submit(self, fn, *args, **kwargs):
        self.__excutor.submit(fn, args, kwargs)
        
        
    def acquire(self):
        self.lock.acquire(True)
        
    def release(self):
        self.lock.release()
        
        
    def get_client(self, client_id: int) -> TrainerClient:
        client = self.clients_pool.get(client_id, None)
        if client is None:
            client = TrainerClient(self, client_id)
            self.clients_pool[client_id] = client
        
        return client
    
    def get_manager_client(self, client_id: int) -> ManagerClient:
        client = self.clients_pool.get(client_id, None)
        if client is None:
            client = ManagerClient(self, client_id)
            self.clients_pool[client_id] = client
        
        return client
        
    
        
        
    
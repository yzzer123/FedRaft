

from concurrent.futures import ThreadPoolExecutor
from service.TrainerClient import TrainerClient
from utils import Properties

logger = Properties.getLogger(__name__)


class NodeState(object):
    """_summary_
        节点状态信息，包括通信连接池、节点角色等信息
    """
    
    LEADER = 1
    FOLLOWER = 2
    CANDIDATE = 3
    UNKNOWN = 4
    
    node_state = None
    
    def __init__(self) -> None:
        self.state = NodeState.FOLLOWER
        self.clients_pool = {}  # 连接池
        self.term = 0  # 任期
        self.model = None  # 模型
        self.models = []  # 汇总模型的列表
        self.clients_pool = {}  # 用于通信的客户端
        self._excutor = ThreadPoolExecutor(max_workers=Properties.getInt(Properties.TRAINER_CLIENT_THREADS))
        
        
    def get_client(self, host: str, port: int) -> TrainerClient:
        client_key = f"{host}:{port}"
        client = self.clients_pool.get(client_key, None)
        if client is None:
            client = TrainerClient(self._excutor, host, port)
            self.clients_pool[client_key] = client
        
        return client
        
    
        
        
    
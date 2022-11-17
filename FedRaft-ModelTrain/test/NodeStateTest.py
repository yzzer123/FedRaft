from rpc import NodeState
from rpc import SyncWithTrainerRequest

def test():
    # print(NodeState.TMP_LEADER)
    print(SyncWithTrainerRequest(term=9999999).current_model_index)
    


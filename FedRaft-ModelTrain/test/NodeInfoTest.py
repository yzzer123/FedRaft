from beans.NodeInfo import NodeInfo
       

def test():
    nodeinfo = NodeInfo("10.112.195.22", 16555, 16789)
    print(f"nodeinfo = {nodeinfo.get_id()}")
    print(f"nodeinfoID = {NodeInfo.id_to_ip(nodeinfo.get_id())}")
                 
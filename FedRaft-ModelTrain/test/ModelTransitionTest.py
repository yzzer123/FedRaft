
import asyncio
from service.NodeState import NodeState
from service.TrainerServer import TrainerServer
from test.ModelSerializeTest import test_model_eval
from utils.Configuration import Properties
from torchvision.models import wide_resnet101_2, vit_h_14, ViT_H_14_Weights, Wide_ResNet101_2_Weights
import time
from utils.ModelSerializeUtils import model_to_bytes


logger = Properties.getLogger(__name__)


async def test_async():
    model = wide_resnet101_2(weights=Wide_ResNet101_2_Weights.IMAGENET1K_V1)
    # model = vit_h_14(weights=ViT_H_14_Weights.IMAGENET1K_SWAG_E2E_V1)
    # trainer_server = TrainerServer()
    # await trainer_server.start()
    # logger.info(f"model size: {len(model_to_bytes(model))}")
    # test_model_eval(model)
    node: NodeState = NodeState()
    # node: NodeState = NodeState.node_state
    client = node.get_client("localhost", Properties.getInt(Properties.TRAINER_SERVER_PORT))
    await client.send_model_to_leader(model)
    logger.info("async send")
    # time.sleep(3.)
    # test_model_eval(node.models[0])
    # logger.info(str(model.state_dict()) == str(node.models[0].state_dict()))
    # await trainer_server.blockingUtilShudown()
    
def test():
    asyncio.run(test_async())
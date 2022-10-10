

import time
from torchvision.models import wide_resnet101_2, Wide_ResNet101_2_Weights, vit_h_14, ViT_H_14_Weights
from torchvision.io import read_image
from torch import nn
from functools import partial
from torchvision.models._meta import _IMAGENET_CATEGORIES
from torchvision.transforms._presets import ImageClassification
from utils import model_to_chunks, chunks_to_model
from utils.Configuration import Properties
from rpc.log_message_pb2 import LogResponse, LogRequest


logger = Properties.getLogger(str(__name__))

def test_model_eval(model: nn.Module):

    img = read_image("assets/grace_hopper_517x606.jpg")

    model.eval()

    # Step 2: Initialize the inference transforms
    preprocess = partial(ImageClassification, crop_size=224)()

    # Step 3: Apply inference preprocessing transforms
    batch = preprocess(img).unsqueeze(0)

    # Step 4: Use the model and print the predicted category
    prediction = model(batch).squeeze(0).softmax(0)
    class_id = prediction.argmax().item()
    score = prediction[class_id].item()
    

    
    category_name = _IMAGENET_CATEGORIES[class_id]
    logger.info(f"{category_name}: {100 * score:.1f}%")
    

    

def test():
    model = wide_resnet101_2(weights=Wide_ResNet101_2_Weights.IMAGENET1K_V1)
    # model = vit_h_14(weights=ViT_H_14_Weights.IMAGENET1K_SWAG_E2E_V1)
    
    # test_model_eval(model)
    chunks = []
    for chunk in model_to_chunks(model):
        chunks.append(chunk)
    t1 = time.time()
    model2 = chunks_to_model(chunks)
    t2 = time.time()
    logger.info(t2 - t1)
    # test_model_eval(model2)
    
    logger.info(str(model2.state_dict()) == str(model.state_dict()))
    
def test_proto_message():
    response = LogResponse(local_index=1, log_size=1)
    logger.info(f"{type(response)}")
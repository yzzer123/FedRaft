

from ctypes import sizeof
from torchvision.models import wide_resnet101_2, Wide_ResNet101_2_Weights
from torchvision.io import read_image
from torch import nn
from functools import partial
from torchvision.models._meta import _IMAGENET_CATEGORIES
from torchvision.transforms._presets import ImageClassification
import torch
import pickle

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
    print(f"{category_name}: {100 * score:.1f}%")
    


def model_to_bytesString(model: nn.Module):
    state_dict = model.state_dict()
    state_dict_bytes = pickle.dumps(state_dict)
    return state_dict_bytes
    


if __name__ == "__main__":
    model = wide_resnet101_2(weights=Wide_ResNet101_2_Weights.IMAGENET1K_V1)
    model_to_bytesString(model)
    # test_model_eval(model)


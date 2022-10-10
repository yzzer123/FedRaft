#!/bin/bash

# python解释器路径 python interpreter path

python -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc -I../FedRaft-Core/src/main/resources log_message.proto
python -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc -I../FedRaft-Core/src/main/resources fedraft_service.proto

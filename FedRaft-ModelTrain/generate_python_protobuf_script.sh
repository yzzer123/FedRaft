#!/bin/bash

# python解释器路径 python interpreter path

python3 -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc -I../FedRaft-Core/src/main/resources log_message.proto
python3 -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc -I../FedRaft-Core/src/main/resources  fedraft_service.proto

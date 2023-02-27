#!/bin/bash

# python解释器路径 python interpreter path

python3 -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc  --pyi_out=./rpc -I../proto/ trainer_service.proto
python3 -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc  --pyi_out=./rpc -I../proto trainer_message.proto
python3 -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc  --pyi_out=./rpc -I../proto/ manager_service.proto
python3 -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc  --pyi_out=./rpc -I../proto manager_message.proto
python3 -m grpc_tools.protoc --python_out=./rpc --grpc_python_out=./rpc  --pyi_out=./rpc -I../proto jobmanager_message.proto

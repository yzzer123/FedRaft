#!/usr/bin/env bash

SHELL_FOLDER=$(cd "$(dirname "$0")";pwd)


source $SHELL_FOLDER/env.sh
export PYTHONPATH=$SHELL_FOLDER/../Trainer
cd $SHELL_FOLDER/../Trainer

if [ $# -lt 1 ]
then
 echo "empty argument is invalid, arguments:[start|stop|status|install]"
fi


case $1 in
"start")
if [ $# -lt 2 ]
then
 echo "port argument is needed"
 exit
fi
 $PYTHON_HOME/bin/python3 -m service -p $2
;;
"stop")
;;
"status")
;;
"install")
    if [ $# -lt 2 ]
    then
    echo "install argument is needed [cpu|gpu]"
    exit
    fi
    case $2 in 
    "cpu")
    $PYTHON_HOME/bin/pip3 install grpcio==1.49.1 grpcio-tools==1.49.1
    $PYTHON_ENV_PATH/bin/pip3 install torch==1.12.1+cpu --extra-index-url https://download.pytorch.org/whl/cpu
    $PYTHON_ENV_PATH/bin/pip3 install torchvision==0.13.1+cpu --extra-index-url https://download.pytorch.org/whl/cpu
    $PYTHON_ENV_PATH/bin/pip3 install torchaudio==0.12.1 --extra-index-url https://download.pytorch.org/whl/cpu
    ;;
    "gpu")
    $PYTHON_HOME/bin/pip3 install grpcio==1.49.1 grpcio-tools==1.49.1
    $PYTHON_HOME/bin/pip3 install torch==1.12.1+cu113 --extra-index-url https://download.pytorch.org/whl/cu113
    $PYTHON_HOME/bin/pip3 install torchvision==0.13.1+cu113 --extra-index-url https://download.pytorch.org/whl/cu113
    $PYTHON_HOME/bin/pip3 install torchaudio==0.12.1 --extra-index-url https://download.pytorch.org/whl/cu113
    ;;
    *)
    echo "arguments:[cpu|gpu]"
    ;;
    esac
;;
*)
 echo "arguments:[start|stop|status|install]"
;;
esac

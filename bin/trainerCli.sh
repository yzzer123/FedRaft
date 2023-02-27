#!/usr/bin/env bash

SHELL_FOLDER=$(cd "$(dirname "$0")";pwd)


source $SHELL_FOLDER/trainer_env.sh
export PYTHONPATH=$SHELL_FOLDER/../Trainer
cd $SHELL_FOLDER/../Trainer

if [ $# -lt 1 ]
then
 echo "empty argument is invalid, arguments:[start|stop|status｜install]"
fi


case $1 in
"start")
if [ $# -lt 2 ]
then
 echo "port argument is needed"
 exit
fi
 $PYTHON_HOME/bin/python3 $SHELL_FOLDER/../Trainer/main.py -p $2
;;
"stop")
;;
"status")
;;
"install")
$PYTHON_HOME/bin/pip3 install grpcio==1.49.1 grpcio-tools==1.49.1
$PYTHON_HOME/bin/pip3 install torch==1.12.1+cu113 torchvision==0.13.1+cu113 torchaudio==0.12.1 --extra-index-url https://download.pytorch.org/whl/cu113
# CPU version
# $PYTHON_ENV_PATH/bin/pip3 install torch==1.12.1+cpu torchvision==0.13.1+cpu torchaudio==0.12.1 --extra-index-url https://download.pytorch.org/whl/cpu
;;
*)
 echo "arguments:[start|stop|status｜install]"
;;
esac

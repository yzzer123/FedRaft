# -*- coding: utf-8 -*-
"""
@Time       :   2022/10/5 17:25  
@Author     :   yzzer
@Project    :   FedRaft
@File       :   ConfTest.py
"""

from  utils import Properties
import logging


def test():
    logging.info(Properties.get(Properties.TRAINER_SERVER_PORT))

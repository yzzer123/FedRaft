# -*- coding: utf-8 -*-
"""
@Time       :   2022/10/5 17:25  
@Author     :   yzzer
@Project    :   FedRaft
@File       :   ConfTest.py
"""

from utils.Configuration import Properties

print(Properties.get(Properties.TRAINER_SERVER_PORT))

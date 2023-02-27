#!/usr/bin/env python3


import logging

from utils import Properties
from test.test_pickle import obj_test
logging.getLogger().setLevel(Properties.LOGGING_LEVEL)

from test.train_test import main
from test.test_pickle import performace_test, test_model

if __name__ == "__main__":
    obj_test()
    # main()
    # performace_test()
    # test_model()

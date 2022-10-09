#!/usr/bin/env python3


from test.ConfTest import test as conf_test
from test.ModelSerializeTest import test as model_serialize_test
from test.ModelSerializeTest import test_proto_message
from test.ModelTransitionTest import test as model_transition_test
from utils import Properties
import logging

logging.getLogger().setLevel(Properties.LOGGING_LEVEL)


if __name__ == "__main__":
    # conf_test()
    # model_serialize_test()
    model_transition_test()
    
# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: log_message.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder

# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()

DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(
    b'\n\x11log_message.proto\x12\x07\x66\x65\x64raft\"\x97\x01\n\nLogRequest\x12\x0c\n\x04term\x18\x01 \x01(\r\x12\x11\n\tleader_id\x18\x02 \x01(\r\x12\x17\n\x0fpre_model_index\x18\x03 \x01(\r\x12\x16\n\x0epre_model_term\x18\x04 \x01(\r\x12\x15\n\x0bmodel_chunk\x18\x05 \x01(\x0cH\x00\x12\x18\n\x0enetwork_delays\x18\x06 \x01(\x0cH\x00\x42\x06\n\x04\x64\x61ta\"4\n\x0bLogResponse\x12\x13\n\x0blocal_index\x18\x01 \x01(\r\x12\x10\n\x08log_size\x18\x02 \x01(\x04\x42$\n org.bupt.cad.fedraft.rpc.messageP\x01\x62\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'log_message_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:
    DESCRIPTOR._options = None
    DESCRIPTOR._serialized_options = b'\n org.bupt.cad.fedraft.rpc.messageP\001'
    _LOGREQUEST._serialized_start = 31
    _LOGREQUEST._serialized_end = 182
    _LOGRESPONSE._serialized_start = 184
    _LOGRESPONSE._serialized_end = 236
# @@protoc_insertion_point(module_scope)
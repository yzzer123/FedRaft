# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: fedraft_service.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import builder as _builder
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


import log_message_pb2 as log__message__pb2


DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x15\x66\x65\x64raft_service.proto\x12\x07\x66\x65\x64raft\x1a\x11log_message.proto2\xd2\x01\n\x0e\x46\x65\x64RaftService\x12@\n\x0f\x41ppendStreamLog\x12\x13.fedraft.LogRequest\x1a\x14.fedraft.LogResponse\"\x00(\x01\x12\x38\n\tAppendLog\x12\x13.fedraft.LogRequest\x1a\x14.fedraft.LogResponse\"\x00\x12\x44\n\tHeartbeat\x12\x19.fedraft.HeartbeatRequest\x1a\x1a.fedraft.HeartbeatResponse\"\x00\x42$\n org.bupt.cad.fedraft.rpc.serviceP\x01\x62\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'fedraft_service_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n org.bupt.cad.fedraft.rpc.serviceP\001'
  _FEDRAFTSERVICE._serialized_start=54
  _FEDRAFTSERVICE._serialized_end=264
# @@protoc_insertion_point(module_scope)

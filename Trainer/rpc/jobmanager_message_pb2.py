# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: jobmanager_message.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import builder as _builder
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x18jobmanager_message.proto\x12\x07\x66\x65\x64raft\"\x15\n\x13\x41ppendModelsRequest\"\x16\n\x14\x41ppendModelsResponse\"\x10\n\x0eJobVoteRequest\"\x11\n\x0fJobVoteResponse\"4\n\x12JobShutdownRequest\x12\x10\n\x08sourceId\x18\x01 \x01(\x03\x12\x0c\n\x04uuid\x18\x02 \x01(\x05\"\x15\n\x13JobShutdownResponse\"C\n\x13\x41ppendJobLogRequest\x12\x10\n\x08sourceId\x18\x01 \x01(\x03\x12\x0c\n\x04uuid\x18\x02 \x01(\x05\x12\x0c\n\x04logs\x18\x03 \x03(\t\"\x16\n\x14\x41ppendJobLogResponseB+\n\'org.bupt.fedraft.rpc.jobmanager.messageP\x01\x62\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'jobmanager_message_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\'org.bupt.fedraft.rpc.jobmanager.messageP\001'
  _APPENDMODELSREQUEST._serialized_start=37
  _APPENDMODELSREQUEST._serialized_end=58
  _APPENDMODELSRESPONSE._serialized_start=60
  _APPENDMODELSRESPONSE._serialized_end=82
  _JOBVOTEREQUEST._serialized_start=84
  _JOBVOTEREQUEST._serialized_end=100
  _JOBVOTERESPONSE._serialized_start=102
  _JOBVOTERESPONSE._serialized_end=119
  _JOBSHUTDOWNREQUEST._serialized_start=121
  _JOBSHUTDOWNREQUEST._serialized_end=173
  _JOBSHUTDOWNRESPONSE._serialized_start=175
  _JOBSHUTDOWNRESPONSE._serialized_end=196
  _APPENDJOBLOGREQUEST._serialized_start=198
  _APPENDJOBLOGREQUEST._serialized_end=265
  _APPENDJOBLOGRESPONSE._serialized_start=267
  _APPENDJOBLOGRESPONSE._serialized_end=289
# @@protoc_insertion_point(module_scope)
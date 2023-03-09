from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor

class InitModelRequest(_message.Message):
    __slots__ = ["model_chunk", "model_class"]
    MODEL_CHUNK_FIELD_NUMBER: _ClassVar[int]
    MODEL_CLASS_FIELD_NUMBER: _ClassVar[int]
    model_chunk: bytes
    model_class: ModelClass
    def __init__(self, model_class: _Optional[_Union[ModelClass, _Mapping]] = ..., model_chunk: _Optional[bytes] = ...) -> None: ...

class InitModelResponse(_message.Message):
    __slots__ = ["status"]
    STATUS_FIELD_NUMBER: _ClassVar[int]
    status: bool
    def __init__(self, status: bool = ...) -> None: ...

class MergeRequest(_message.Message):
    __slots__ = ["server_ids"]
    SERVER_IDS_FIELD_NUMBER: _ClassVar[int]
    server_ids: _containers.RepeatedScalarFieldContainer[int]
    def __init__(self, server_ids: _Optional[_Iterable[int]] = ...) -> None: ...

class MergeResponse(_message.Message):
    __slots__ = ["model_chunk", "model_eval_log", "server_id"]
    MODEL_CHUNK_FIELD_NUMBER: _ClassVar[int]
    MODEL_EVAL_LOG_FIELD_NUMBER: _ClassVar[int]
    SERVER_ID_FIELD_NUMBER: _ClassVar[int]
    model_chunk: bytes
    model_eval_log: str
    server_id: int
    def __init__(self, server_id: _Optional[int] = ..., model_chunk: _Optional[bytes] = ..., model_eval_log: _Optional[str] = ...) -> None: ...

class ModelClass(_message.Message):
    __slots__ = ["class_name", "local_epoch", "module"]
    CLASS_NAME_FIELD_NUMBER: _ClassVar[int]
    LOCAL_EPOCH_FIELD_NUMBER: _ClassVar[int]
    MODULE_FIELD_NUMBER: _ClassVar[int]
    class_name: str
    local_epoch: int
    module: str
    def __init__(self, module: _Optional[str] = ..., class_name: _Optional[str] = ..., local_epoch: _Optional[int] = ...) -> None: ...

class PushModelRequest(_message.Message):
    __slots__ = ["model_chunk", "server_id"]
    MODEL_CHUNK_FIELD_NUMBER: _ClassVar[int]
    SERVER_ID_FIELD_NUMBER: _ClassVar[int]
    model_chunk: bytes
    server_id: int
    def __init__(self, server_id: _Optional[int] = ..., model_chunk: _Optional[bytes] = ...) -> None: ...

class PushModelResponse(_message.Message):
    __slots__ = ["status"]
    STATUS_FIELD_NUMBER: _ClassVar[int]
    status: bool
    def __init__(self, status: bool = ...) -> None: ...

class TrainRequest(_message.Message):
    __slots__ = ["model_chunk"]
    MODEL_CHUNK_FIELD_NUMBER: _ClassVar[int]
    model_chunk: bytes
    def __init__(self, model_chunk: _Optional[bytes] = ...) -> None: ...

class TrainResponse(_message.Message):
    __slots__ = ["model_chunk"]
    MODEL_CHUNK_FIELD_NUMBER: _ClassVar[int]
    model_chunk: bytes
    def __init__(self, model_chunk: _Optional[bytes] = ...) -> None: ...

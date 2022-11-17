from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional, Union as _Union

CLIENT_TO_CLIENT: LogType
CLIENT_TO_LEADER: LogType
DESCRIPTOR: _descriptor.FileDescriptor
LEADER_TO_CLIENT: LogType

class LogPullRequest(_message.Message):
    __slots__ = ["leader_id", "log_type", "term"]
    LEADER_ID_FIELD_NUMBER: _ClassVar[int]
    LOG_TYPE_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    leader_id: int
    log_type: LogType
    term: int
    def __init__(self, term: _Optional[int] = ..., leader_id: _Optional[int] = ..., log_type: _Optional[_Union[LogType, str]] = ...) -> None: ...

class LogPullResponse(_message.Message):
    __slots__ = ["model_chunk", "model_index"]
    MODEL_CHUNK_FIELD_NUMBER: _ClassVar[int]
    MODEL_INDEX_FIELD_NUMBER: _ClassVar[int]
    model_chunk: bytes
    model_index: int
    def __init__(self, model_chunk: _Optional[bytes] = ..., model_index: _Optional[int] = ...) -> None: ...

class LogRequest(_message.Message):
    __slots__ = ["leader_id", "log_type", "model_chunk", "model_index", "term"]
    LEADER_ID_FIELD_NUMBER: _ClassVar[int]
    LOG_TYPE_FIELD_NUMBER: _ClassVar[int]
    MODEL_CHUNK_FIELD_NUMBER: _ClassVar[int]
    MODEL_INDEX_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    leader_id: int
    log_type: LogType
    model_chunk: bytes
    model_index: int
    term: int
    def __init__(self, term: _Optional[int] = ..., leader_id: _Optional[int] = ..., model_index: _Optional[int] = ..., log_type: _Optional[_Union[LogType, str]] = ..., model_chunk: _Optional[bytes] = ...) -> None: ...

class LogResponse(_message.Message):
    __slots__ = ["local_index", "log_size"]
    LOCAL_INDEX_FIELD_NUMBER: _ClassVar[int]
    LOG_SIZE_FIELD_NUMBER: _ClassVar[int]
    local_index: int
    log_size: int
    def __init__(self, local_index: _Optional[int] = ..., log_size: _Optional[int] = ...) -> None: ...

class LogType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []

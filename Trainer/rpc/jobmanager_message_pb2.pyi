from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class AppendJobLogRequest(_message.Message):
    __slots__ = ["logs", "sourceId", "uuid"]
    LOGS_FIELD_NUMBER: _ClassVar[int]
    SOURCEID_FIELD_NUMBER: _ClassVar[int]
    UUID_FIELD_NUMBER: _ClassVar[int]
    logs: _containers.RepeatedScalarFieldContainer[str]
    sourceId: int
    uuid: int
    def __init__(self, sourceId: _Optional[int] = ..., uuid: _Optional[int] = ..., logs: _Optional[_Iterable[str]] = ...) -> None: ...

class AppendJobLogResponse(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class AppendModelsRequest(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class AppendModelsResponse(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class JobShutdownRequest(_message.Message):
    __slots__ = ["sourceId", "uuid"]
    SOURCEID_FIELD_NUMBER: _ClassVar[int]
    UUID_FIELD_NUMBER: _ClassVar[int]
    sourceId: int
    uuid: int
    def __init__(self, sourceId: _Optional[int] = ..., uuid: _Optional[int] = ...) -> None: ...

class JobShutdownResponse(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class JobVoteRequest(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class JobVoteResponse(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

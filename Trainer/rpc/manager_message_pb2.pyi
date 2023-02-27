from google.protobuf.internal import containers as _containers
from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

CANDIDATE: ManagerStatus
DESCRIPTOR: _descriptor.FileDescriptor
FOLLOWER: ManagerStatus
LEADER: ManagerStatus

class AppendEntriesRequest(_message.Message):
    __slots__ = ["delay", "entryIndex", "leaderId", "nodeIds", "term"]
    DELAY_FIELD_NUMBER: _ClassVar[int]
    ENTRYINDEX_FIELD_NUMBER: _ClassVar[int]
    LEADERID_FIELD_NUMBER: _ClassVar[int]
    NODEIDS_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    delay: _containers.RepeatedScalarFieldContainer[int]
    entryIndex: int
    leaderId: int
    nodeIds: _containers.RepeatedScalarFieldContainer[int]
    term: int
    def __init__(self, term: _Optional[int] = ..., leaderId: _Optional[int] = ..., entryIndex: _Optional[int] = ..., nodeIds: _Optional[_Iterable[int]] = ..., delay: _Optional[_Iterable[int]] = ...) -> None: ...

class AppendEntriesResponse(_message.Message):
    __slots__ = ["delay", "term"]
    DELAY_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    delay: int
    term: int
    def __init__(self, term: _Optional[int] = ..., delay: _Optional[int] = ...) -> None: ...

class CodeFile(_message.Message):
    __slots__ = ["code", "fileName"]
    CODE_FIELD_NUMBER: _ClassVar[int]
    FILENAME_FIELD_NUMBER: _ClassVar[int]
    code: str
    fileName: str
    def __init__(self, fileName: _Optional[str] = ..., code: _Optional[str] = ...) -> None: ...

class JobConfiguration(_message.Message):
    __slots__ = ["codeFile", "global_epoch", "participants", "sourceId", "uuid"]
    CODEFILE_FIELD_NUMBER: _ClassVar[int]
    GLOBAL_EPOCH_FIELD_NUMBER: _ClassVar[int]
    PARTICIPANTS_FIELD_NUMBER: _ClassVar[int]
    SOURCEID_FIELD_NUMBER: _ClassVar[int]
    UUID_FIELD_NUMBER: _ClassVar[int]
    codeFile: CodeFile
    global_epoch: int
    participants: _containers.RepeatedScalarFieldContainer[int]
    sourceId: int
    uuid: int
    def __init__(self, uuid: _Optional[int] = ..., sourceId: _Optional[int] = ..., participants: _Optional[_Iterable[int]] = ..., codeFile: _Optional[_Union[CodeFile, _Mapping]] = ..., global_epoch: _Optional[int] = ...) -> None: ...

class JobSubmitRequest(_message.Message):
    __slots__ = ["conf", "modelChunk"]
    CONF_FIELD_NUMBER: _ClassVar[int]
    MODELCHUNK_FIELD_NUMBER: _ClassVar[int]
    conf: JobConfiguration
    modelChunk: bytes
    def __init__(self, conf: _Optional[_Union[JobConfiguration, _Mapping]] = ..., modelChunk: _Optional[bytes] = ...) -> None: ...

class JobSubmitResponse(_message.Message):
    __slots__ = ["chunk", "logs", "success"]
    CHUNK_FIELD_NUMBER: _ClassVar[int]
    LOGS_FIELD_NUMBER: _ClassVar[int]
    SUCCESS_FIELD_NUMBER: _ClassVar[int]
    chunk: bytes
    logs: str
    success: bool
    def __init__(self, success: bool = ..., logs: _Optional[str] = ..., chunk: _Optional[bytes] = ...) -> None: ...

class ManagerVoteRequest(_message.Message):
    __slots__ = ["candidateId", "entryIndex", "term"]
    CANDIDATEID_FIELD_NUMBER: _ClassVar[int]
    ENTRYINDEX_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    candidateId: int
    entryIndex: int
    term: int
    def __init__(self, term: _Optional[int] = ..., candidateId: _Optional[int] = ..., entryIndex: _Optional[int] = ...) -> None: ...

class ManagerVoteResponse(_message.Message):
    __slots__ = ["term", "voteGranted"]
    TERM_FIELD_NUMBER: _ClassVar[int]
    VOTEGRANTED_FIELD_NUMBER: _ClassVar[int]
    term: int
    voteGranted: bool
    def __init__(self, term: _Optional[int] = ..., voteGranted: bool = ...) -> None: ...

class ManagerStatus(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []

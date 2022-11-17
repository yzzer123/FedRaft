from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class TriggerElectionRequest(_message.Message):
    __slots__ = ["leader_id", "leader_model_index", "term"]
    LEADER_ID_FIELD_NUMBER: _ClassVar[int]
    LEADER_MODEL_INDEX_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    leader_id: int
    leader_model_index: int
    term: int
    def __init__(self, term: _Optional[int] = ..., leader_id: _Optional[int] = ..., leader_model_index: _Optional[int] = ...) -> None: ...

class TriggerElectionResponse(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class VoteRequest(_message.Message):
    __slots__ = ["candidate_id", "model_index", "network_delays", "node_ids", "term"]
    CANDIDATE_ID_FIELD_NUMBER: _ClassVar[int]
    MODEL_INDEX_FIELD_NUMBER: _ClassVar[int]
    NETWORK_DELAYS_FIELD_NUMBER: _ClassVar[int]
    NODE_IDS_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    candidate_id: int
    model_index: int
    network_delays: _containers.RepeatedScalarFieldContainer[int]
    node_ids: _containers.RepeatedScalarFieldContainer[int]
    term: int
    def __init__(self, term: _Optional[int] = ..., candidate_id: _Optional[int] = ..., model_index: _Optional[int] = ..., node_ids: _Optional[_Iterable[int]] = ..., network_delays: _Optional[_Iterable[int]] = ...) -> None: ...

class VoteResponse(_message.Message):
    __slots__ = ["delay", "term", "voteGranted"]
    DELAY_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    VOTEGRANTED_FIELD_NUMBER: _ClassVar[int]
    delay: int
    term: int
    voteGranted: bool
    def __init__(self, term: _Optional[int] = ..., delay: _Optional[int] = ..., voteGranted: bool = ...) -> None: ...

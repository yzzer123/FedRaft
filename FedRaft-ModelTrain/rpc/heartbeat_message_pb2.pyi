from google.protobuf.internal import containers as _containers
from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Optional as _Optional, Union as _Union

CANDIDATE: NodeState
DESCRIPTOR: _descriptor.FileDescriptor
FOLLOWER: NodeState
LEADER: NodeState
SAFE_MODE: NodeState
TMP_LEADER: NodeState

class HeartbeatRequest(_message.Message):
    __slots__ = ["leader_id", "leader_model_index", "leader_state", "network_delays", "node_ids", "term", "timestamp"]
    LEADER_ID_FIELD_NUMBER: _ClassVar[int]
    LEADER_MODEL_INDEX_FIELD_NUMBER: _ClassVar[int]
    LEADER_STATE_FIELD_NUMBER: _ClassVar[int]
    NETWORK_DELAYS_FIELD_NUMBER: _ClassVar[int]
    NODE_IDS_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    TIMESTAMP_FIELD_NUMBER: _ClassVar[int]
    leader_id: int
    leader_model_index: int
    leader_state: NodeState
    network_delays: _containers.RepeatedScalarFieldContainer[int]
    node_ids: _containers.RepeatedScalarFieldContainer[int]
    term: int
    timestamp: int
    def __init__(self, term: _Optional[int] = ..., leader_id: _Optional[int] = ..., leader_state: _Optional[_Union[NodeState, str]] = ..., leader_model_index: _Optional[int] = ..., timestamp: _Optional[int] = ..., node_ids: _Optional[_Iterable[int]] = ..., network_delays: _Optional[_Iterable[int]] = ...) -> None: ...

class HeartbeatResponse(_message.Message):
    __slots__ = ["network_delay", "node_state", "term", "timestamp"]
    NETWORK_DELAY_FIELD_NUMBER: _ClassVar[int]
    NODE_STATE_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    TIMESTAMP_FIELD_NUMBER: _ClassVar[int]
    network_delay: int
    node_state: NodeState
    term: int
    timestamp: int
    def __init__(self, network_delay: _Optional[int] = ..., timestamp: _Optional[int] = ..., node_state: _Optional[_Union[NodeState, str]] = ..., term: _Optional[int] = ...) -> None: ...

class SyncWithTrainerRequest(_message.Message):
    __slots__ = ["current_model_index", "leader_id", "node_ids", "node_state", "term", "timestamp"]
    CURRENT_MODEL_INDEX_FIELD_NUMBER: _ClassVar[int]
    LEADER_ID_FIELD_NUMBER: _ClassVar[int]
    NODE_IDS_FIELD_NUMBER: _ClassVar[int]
    NODE_STATE_FIELD_NUMBER: _ClassVar[int]
    TERM_FIELD_NUMBER: _ClassVar[int]
    TIMESTAMP_FIELD_NUMBER: _ClassVar[int]
    current_model_index: int
    leader_id: int
    node_ids: _containers.RepeatedScalarFieldContainer[int]
    node_state: NodeState
    term: int
    timestamp: int
    def __init__(self, term: _Optional[int] = ..., leader_id: _Optional[int] = ..., current_model_index: _Optional[int] = ..., timestamp: _Optional[int] = ..., node_state: _Optional[_Union[NodeState, str]] = ..., node_ids: _Optional[_Iterable[int]] = ...) -> None: ...

class SyncWithTrainerResponse(_message.Message):
    __slots__ = ["current_model_index", "timestamp"]
    CURRENT_MODEL_INDEX_FIELD_NUMBER: _ClassVar[int]
    TIMESTAMP_FIELD_NUMBER: _ClassVar[int]
    current_model_index: int
    timestamp: int
    def __init__(self, current_model_index: _Optional[int] = ..., timestamp: _Optional[int] = ...) -> None: ...

class NodeState(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []

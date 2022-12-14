package org.bupt.cad.fedraft.rpc.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.49.1)",
        comments = "Source: fedraft_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FedRaftServiceGrpc {

    public static final String SERVICE_NAME = "fedraft.FedRaftService";
    private static final int METHODID_APPEND_LOG = 0;
    private static final int METHODID_HEARTBEAT = 1;
    private static final int METHODID_SYNC_WITH_TRAINER = 2;
    private static final int METHODID_TRIGGER_ELECTION = 3;
    private static final int METHODID_REQUEST_VOTE = 4;
    private static final int METHODID_APPEND_STREAM_LOG = 5;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest,
            org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendStreamLogMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest,
            org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendLogMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.HeartbeatRequest,
            org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> getHeartbeatMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest,
            org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> getSyncWithTrainerMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest,
            org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> getTriggerElectionMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.VoteRequest,
            org.bupt.cad.fedraft.rpc.message.VoteResponse> getRequestVoteMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private FedRaftServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "AppendStreamLog",
            requestType = org.bupt.cad.fedraft.rpc.message.LogRequest.class,
            responseType = org.bupt.cad.fedraft.rpc.message.LogResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
    public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest,
            org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendStreamLogMethod() {
        io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest, org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendStreamLogMethod;
        if ((getAppendStreamLogMethod = FedRaftServiceGrpc.getAppendStreamLogMethod) == null) {
            synchronized (FedRaftServiceGrpc.class) {
                if ((getAppendStreamLogMethod = FedRaftServiceGrpc.getAppendStreamLogMethod) == null) {
                    FedRaftServiceGrpc.getAppendStreamLogMethod = getAppendStreamLogMethod =
                            io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.LogRequest, org.bupt.cad.fedraft.rpc.message.LogResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendStreamLog"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.LogRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.LogResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new FedRaftServiceMethodDescriptorSupplier("AppendStreamLog"))
                                    .build();
                }
            }
        }
        return getAppendStreamLogMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "AppendLog",
            requestType = org.bupt.cad.fedraft.rpc.message.LogRequest.class,
            responseType = org.bupt.cad.fedraft.rpc.message.LogResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest,
            org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendLogMethod() {
        io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest, org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendLogMethod;
        if ((getAppendLogMethod = FedRaftServiceGrpc.getAppendLogMethod) == null) {
            synchronized (FedRaftServiceGrpc.class) {
                if ((getAppendLogMethod = FedRaftServiceGrpc.getAppendLogMethod) == null) {
                    FedRaftServiceGrpc.getAppendLogMethod = getAppendLogMethod =
                            io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.LogRequest, org.bupt.cad.fedraft.rpc.message.LogResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendLog"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.LogRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.LogResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new FedRaftServiceMethodDescriptorSupplier("AppendLog"))
                                    .build();
                }
            }
        }
        return getAppendLogMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "Heartbeat",
            requestType = org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.class,
            responseType = org.bupt.cad.fedraft.rpc.message.HeartbeatResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.HeartbeatRequest,
            org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> getHeartbeatMethod() {
        io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.HeartbeatRequest, org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> getHeartbeatMethod;
        if ((getHeartbeatMethod = FedRaftServiceGrpc.getHeartbeatMethod) == null) {
            synchronized (FedRaftServiceGrpc.class) {
                if ((getHeartbeatMethod = FedRaftServiceGrpc.getHeartbeatMethod) == null) {
                    FedRaftServiceGrpc.getHeartbeatMethod = getHeartbeatMethod =
                            io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.HeartbeatRequest, org.bupt.cad.fedraft.rpc.message.HeartbeatResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Heartbeat"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.HeartbeatResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new FedRaftServiceMethodDescriptorSupplier("Heartbeat"))
                                    .build();
                }
            }
        }
        return getHeartbeatMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "SyncWithTrainer",
            requestType = org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest.class,
            responseType = org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest,
            org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> getSyncWithTrainerMethod() {
        io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest, org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> getSyncWithTrainerMethod;
        if ((getSyncWithTrainerMethod = FedRaftServiceGrpc.getSyncWithTrainerMethod) == null) {
            synchronized (FedRaftServiceGrpc.class) {
                if ((getSyncWithTrainerMethod = FedRaftServiceGrpc.getSyncWithTrainerMethod) == null) {
                    FedRaftServiceGrpc.getSyncWithTrainerMethod = getSyncWithTrainerMethod =
                            io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest, org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SyncWithTrainer"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new FedRaftServiceMethodDescriptorSupplier("SyncWithTrainer"))
                                    .build();
                }
            }
        }
        return getSyncWithTrainerMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "TriggerElection",
            requestType = org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.class,
            responseType = org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest,
            org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> getTriggerElectionMethod() {
        io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest, org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> getTriggerElectionMethod;
        if ((getTriggerElectionMethod = FedRaftServiceGrpc.getTriggerElectionMethod) == null) {
            synchronized (FedRaftServiceGrpc.class) {
                if ((getTriggerElectionMethod = FedRaftServiceGrpc.getTriggerElectionMethod) == null) {
                    FedRaftServiceGrpc.getTriggerElectionMethod = getTriggerElectionMethod =
                            io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest, org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TriggerElection"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new FedRaftServiceMethodDescriptorSupplier("TriggerElection"))
                                    .build();
                }
            }
        }
        return getTriggerElectionMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "RequestVote",
            requestType = org.bupt.cad.fedraft.rpc.message.VoteRequest.class,
            responseType = org.bupt.cad.fedraft.rpc.message.VoteResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.VoteRequest,
            org.bupt.cad.fedraft.rpc.message.VoteResponse> getRequestVoteMethod() {
        io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.VoteRequest, org.bupt.cad.fedraft.rpc.message.VoteResponse> getRequestVoteMethod;
        if ((getRequestVoteMethod = FedRaftServiceGrpc.getRequestVoteMethod) == null) {
            synchronized (FedRaftServiceGrpc.class) {
                if ((getRequestVoteMethod = FedRaftServiceGrpc.getRequestVoteMethod) == null) {
                    FedRaftServiceGrpc.getRequestVoteMethod = getRequestVoteMethod =
                            io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.VoteRequest, org.bupt.cad.fedraft.rpc.message.VoteResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestVote"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.VoteRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.VoteResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new FedRaftServiceMethodDescriptorSupplier("RequestVote"))
                                    .build();
                }
            }
        }
        return getRequestVoteMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static FedRaftServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<FedRaftServiceStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<FedRaftServiceStub>() {
                    @java.lang.Override
                    public FedRaftServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new FedRaftServiceStub(channel, callOptions);
                    }
                };
        return FedRaftServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static FedRaftServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<FedRaftServiceBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<FedRaftServiceBlockingStub>() {
                    @java.lang.Override
                    public FedRaftServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new FedRaftServiceBlockingStub(channel, callOptions);
                    }
                };
        return FedRaftServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static FedRaftServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<FedRaftServiceFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<FedRaftServiceFutureStub>() {
                    @java.lang.Override
                    public FedRaftServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new FedRaftServiceFutureStub(channel, callOptions);
                    }
                };
        return FedRaftServiceFutureStub.newStub(factory, channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (FedRaftServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new FedRaftServiceFileDescriptorSupplier())
                            .addMethod(getAppendStreamLogMethod())
                            .addMethod(getAppendLogMethod())
                            .addMethod(getHeartbeatMethod())
                            .addMethod(getSyncWithTrainerMethod())
                            .addMethod(getTriggerElectionMethod())
                            .addMethod(getRequestVoteMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     */
    public static abstract class FedRaftServiceImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         * Raft ??????????????????
         * </pre>
         */
        public io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogRequest> appendStreamLog(
                io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse> responseObserver) {
            return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAppendStreamLogMethod(), responseObserver);
        }

        /**
         */
        public void appendLog(org.bupt.cad.fedraft.rpc.message.LogRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAppendLogMethod(), responseObserver);
        }

        /**
         * <pre>
         * ????????????
         * </pre>
         */
        public void heartbeat(org.bupt.cad.fedraft.rpc.message.HeartbeatRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHeartbeatMethod(), responseObserver);
        }

        /**
         */
        public void syncWithTrainer(org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest request,
                                    io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSyncWithTrainerMethod(), responseObserver);
        }

        /**
         * <pre>
         * ????????????????????????????????????
         * </pre>
         */
        public void triggerElection(org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest request,
                                    io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTriggerElectionMethod(), responseObserver);
        }

        /**
         * <pre>
         * ????????????
         * </pre>
         */
        public void requestVote(org.bupt.cad.fedraft.rpc.message.VoteRequest request,
                                io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.VoteResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestVoteMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getAppendStreamLogMethod(),
                            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
                                    new MethodHandlers<
                                            org.bupt.cad.fedraft.rpc.message.LogRequest,
                                            org.bupt.cad.fedraft.rpc.message.LogResponse>(
                                            this, METHODID_APPEND_STREAM_LOG)))
                    .addMethod(
                            getAppendLogMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.cad.fedraft.rpc.message.LogRequest,
                                            org.bupt.cad.fedraft.rpc.message.LogResponse>(
                                            this, METHODID_APPEND_LOG)))
                    .addMethod(
                            getHeartbeatMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.cad.fedraft.rpc.message.HeartbeatRequest,
                                            org.bupt.cad.fedraft.rpc.message.HeartbeatResponse>(
                                            this, METHODID_HEARTBEAT)))
                    .addMethod(
                            getSyncWithTrainerMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest,
                                            org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse>(
                                            this, METHODID_SYNC_WITH_TRAINER)))
                    .addMethod(
                            getTriggerElectionMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest,
                                            org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse>(
                                            this, METHODID_TRIGGER_ELECTION)))
                    .addMethod(
                            getRequestVoteMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.cad.fedraft.rpc.message.VoteRequest,
                                            org.bupt.cad.fedraft.rpc.message.VoteResponse>(
                                            this, METHODID_REQUEST_VOTE)))
                    .build();
        }
    }

    /**
     */
    public static final class FedRaftServiceStub extends io.grpc.stub.AbstractAsyncStub<FedRaftServiceStub> {
        private FedRaftServiceStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected FedRaftServiceStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FedRaftServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * Raft ??????????????????
         * </pre>
         */
        public io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogRequest> appendStreamLog(
                io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse> responseObserver) {
            return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
                    getChannel().newCall(getAppendStreamLogMethod(), getCallOptions()), responseObserver);
        }

        /**
         */
        public void appendLog(org.bupt.cad.fedraft.rpc.message.LogRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getAppendLogMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         * <pre>
         * ????????????
         * </pre>
         */
        public void heartbeat(org.bupt.cad.fedraft.rpc.message.HeartbeatRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getHeartbeatMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void syncWithTrainer(org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest request,
                                    io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getSyncWithTrainerMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         * <pre>
         * ????????????????????????????????????
         * </pre>
         */
        public void triggerElection(org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest request,
                                    io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getTriggerElectionMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         * <pre>
         * ????????????
         * </pre>
         */
        public void requestVote(org.bupt.cad.fedraft.rpc.message.VoteRequest request,
                                io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.VoteResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getRequestVoteMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class FedRaftServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FedRaftServiceBlockingStub> {
        private FedRaftServiceBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected FedRaftServiceBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FedRaftServiceBlockingStub(channel, callOptions);
        }

        /**
         */
        public org.bupt.cad.fedraft.rpc.message.LogResponse appendLog(org.bupt.cad.fedraft.rpc.message.LogRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getAppendLogMethod(), getCallOptions(), request);
        }

        /**
         * <pre>
         * ????????????
         * </pre>
         */
        public org.bupt.cad.fedraft.rpc.message.HeartbeatResponse heartbeat(org.bupt.cad.fedraft.rpc.message.HeartbeatRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getHeartbeatMethod(), getCallOptions(), request);
        }

        /**
         */
        public org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse syncWithTrainer(org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getSyncWithTrainerMethod(), getCallOptions(), request);
        }

        /**
         * <pre>
         * ????????????????????????????????????
         * </pre>
         */
        public org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse triggerElection(org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getTriggerElectionMethod(), getCallOptions(), request);
        }

        /**
         * <pre>
         * ????????????
         * </pre>
         */
        public org.bupt.cad.fedraft.rpc.message.VoteResponse requestVote(org.bupt.cad.fedraft.rpc.message.VoteRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getRequestVoteMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class FedRaftServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FedRaftServiceFutureStub> {
        private FedRaftServiceFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected FedRaftServiceFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FedRaftServiceFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.LogResponse> appendLog(
                org.bupt.cad.fedraft.rpc.message.LogRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getAppendLogMethod(), getCallOptions()), request);
        }

        /**
         * <pre>
         * ????????????
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> heartbeat(
                org.bupt.cad.fedraft.rpc.message.HeartbeatRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getHeartbeatMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> syncWithTrainer(
                org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getSyncWithTrainerMethod(), getCallOptions()), request);
        }

        /**
         * <pre>
         * ????????????????????????????????????
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> triggerElection(
                org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getTriggerElectionMethod(), getCallOptions()), request);
        }

        /**
         * <pre>
         * ????????????
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.VoteResponse> requestVote(
                org.bupt.cad.fedraft.rpc.message.VoteRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getRequestVoteMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final FedRaftServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(FedRaftServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_APPEND_LOG:
                    serviceImpl.appendLog((org.bupt.cad.fedraft.rpc.message.LogRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse>) responseObserver);
                    break;
                case METHODID_HEARTBEAT:
                    serviceImpl.heartbeat((org.bupt.cad.fedraft.rpc.message.HeartbeatRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.HeartbeatResponse>) responseObserver);
                    break;
                case METHODID_SYNC_WITH_TRAINER:
                    serviceImpl.syncWithTrainer((org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse>) responseObserver);
                    break;
                case METHODID_TRIGGER_ELECTION:
                    serviceImpl.triggerElection((org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse>) responseObserver);
                    break;
                case METHODID_REQUEST_VOTE:
                    serviceImpl.requestVote((org.bupt.cad.fedraft.rpc.message.VoteRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.VoteResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_APPEND_STREAM_LOG:
                    return (io.grpc.stub.StreamObserver<Req>) serviceImpl.appendStreamLog(
                            (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse>) responseObserver);
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class FedRaftServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        FedRaftServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return org.bupt.cad.fedraft.rpc.service.FedraftService.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("FedRaftService");
        }
    }

    private static final class FedRaftServiceFileDescriptorSupplier
            extends FedRaftServiceBaseDescriptorSupplier {
        FedRaftServiceFileDescriptorSupplier() {
        }
    }

    private static final class FedRaftServiceMethodDescriptorSupplier
            extends FedRaftServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        FedRaftServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}

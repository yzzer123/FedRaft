package org.bupt.fedraft.rpc.manager.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.50.1)",
        comments = "Source: manager_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ManagerServiceGrpc {

    public static final String SERVICE_NAME = "fedraft.ManagerService";
    private static final int METHODID_APPEND_ENTRIES = 0;
    private static final int METHODID_VOTE_FOR = 1;
    private static final int METHODID_JOB_SHUTDOWN = 2;
    private static final int METHODID_JOB_SUBMIT = 3;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest,
            org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse> getAppendEntriesMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest,
            org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse> getVoteForMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.JobSubmitRequest,
            org.bupt.fedraft.rpc.manager.message.JobSubmitResponse> getJobSubmitMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest,
            org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse> getJobShutdownMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private ManagerServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "AppendEntries",
            requestType = org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.class,
            responseType = org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest,
            org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse> getAppendEntriesMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest, org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse> getAppendEntriesMethod;
        if ((getAppendEntriesMethod = ManagerServiceGrpc.getAppendEntriesMethod) == null) {
            synchronized (ManagerServiceGrpc.class) {
                if ((getAppendEntriesMethod = ManagerServiceGrpc.getAppendEntriesMethod) == null) {
                    ManagerServiceGrpc.getAppendEntriesMethod = getAppendEntriesMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest, org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendEntries"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new ManagerServiceMethodDescriptorSupplier("AppendEntries"))
                                    .build();
                }
            }
        }
        return getAppendEntriesMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "VoteFor",
            requestType = org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.class,
            responseType = org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest,
            org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse> getVoteForMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest, org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse> getVoteForMethod;
        if ((getVoteForMethod = ManagerServiceGrpc.getVoteForMethod) == null) {
            synchronized (ManagerServiceGrpc.class) {
                if ((getVoteForMethod = ManagerServiceGrpc.getVoteForMethod) == null) {
                    ManagerServiceGrpc.getVoteForMethod = getVoteForMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest, org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VoteFor"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new ManagerServiceMethodDescriptorSupplier("VoteFor"))
                                    .build();
                }
            }
        }
        return getVoteForMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "JobSubmit",
            requestType = org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.class,
            responseType = org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.JobSubmitRequest,
            org.bupt.fedraft.rpc.manager.message.JobSubmitResponse> getJobSubmitMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.manager.message.JobSubmitRequest, org.bupt.fedraft.rpc.manager.message.JobSubmitResponse> getJobSubmitMethod;
        if ((getJobSubmitMethod = ManagerServiceGrpc.getJobSubmitMethod) == null) {
            synchronized (ManagerServiceGrpc.class) {
                if ((getJobSubmitMethod = ManagerServiceGrpc.getJobSubmitMethod) == null) {
                    ManagerServiceGrpc.getJobSubmitMethod = getJobSubmitMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.manager.message.JobSubmitRequest, org.bupt.fedraft.rpc.manager.message.JobSubmitResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobSubmit"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.manager.message.JobSubmitRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.manager.message.JobSubmitResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new ManagerServiceMethodDescriptorSupplier("JobSubmit"))
                                    .build();
                }
            }
        }
        return getJobSubmitMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "JobShutdown",
            requestType = org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.class,
            responseType = org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest,
            org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse> getJobShutdownMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest, org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse> getJobShutdownMethod;
        if ((getJobShutdownMethod = ManagerServiceGrpc.getJobShutdownMethod) == null) {
            synchronized (ManagerServiceGrpc.class) {
                if ((getJobShutdownMethod = ManagerServiceGrpc.getJobShutdownMethod) == null) {
                    ManagerServiceGrpc.getJobShutdownMethod = getJobShutdownMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest, org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobShutdown"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new ManagerServiceMethodDescriptorSupplier("JobShutdown"))
                                    .build();
                }
            }
        }
        return getJobShutdownMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static ManagerServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ManagerServiceStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<ManagerServiceStub>() {
                    @java.lang.Override
                    public ManagerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new ManagerServiceStub(channel, callOptions);
                    }
                };
        return ManagerServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static ManagerServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ManagerServiceBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<ManagerServiceBlockingStub>() {
                    @java.lang.Override
                    public ManagerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new ManagerServiceBlockingStub(channel, callOptions);
                    }
                };
        return ManagerServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static ManagerServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ManagerServiceFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<ManagerServiceFutureStub>() {
                    @java.lang.Override
                    public ManagerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new ManagerServiceFutureStub(channel, callOptions);
                    }
                };
        return ManagerServiceFutureStub.newStub(factory, channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (ManagerServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new ManagerServiceFileDescriptorSupplier())
                            .addMethod(getAppendEntriesMethod())
                            .addMethod(getVoteForMethod())
                            .addMethod(getJobSubmitMethod())
                            .addMethod(getJobShutdownMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     */
    public static abstract class ManagerServiceImplBase implements io.grpc.BindableService {

        /**
         */
        public void appendEntries(org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest request,
                                  io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAppendEntriesMethod(), responseObserver);
        }

        /**
         */
        public void voteFor(org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest request,
                            io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVoteForMethod(), responseObserver);
        }

        /**
         */
        public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.JobSubmitRequest> jobSubmit(
                io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.JobSubmitResponse> responseObserver) {
            return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getJobSubmitMethod(), responseObserver);
        }

        /**
         */
        public void jobShutdown(org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest request,
                                io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobShutdownMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getAppendEntriesMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest,
                                            org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse>(
                                            this, METHODID_APPEND_ENTRIES)))
                    .addMethod(
                            getVoteForMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest,
                                            org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse>(
                                            this, METHODID_VOTE_FOR)))
                    .addMethod(
                            getJobSubmitMethod(),
                            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.manager.message.JobSubmitRequest,
                                            org.bupt.fedraft.rpc.manager.message.JobSubmitResponse>(
                                            this, METHODID_JOB_SUBMIT)))
                    .addMethod(
                            getJobShutdownMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest,
                                            org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse>(
                                            this, METHODID_JOB_SHUTDOWN)))
                    .build();
        }
    }

    /**
     */
    public static final class ManagerServiceStub extends io.grpc.stub.AbstractAsyncStub<ManagerServiceStub> {
        private ManagerServiceStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ManagerServiceStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagerServiceStub(channel, callOptions);
        }

        /**
         */
        public void appendEntries(org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest request,
                                  io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getAppendEntriesMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void voteFor(org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest request,
                            io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getVoteForMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.JobSubmitRequest> jobSubmit(
                io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.JobSubmitResponse> responseObserver) {
            return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
                    getChannel().newCall(getJobSubmitMethod(), getCallOptions()), responseObserver);
        }

        /**
         */
        public void jobShutdown(org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest request,
                                io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getJobShutdownMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class ManagerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ManagerServiceBlockingStub> {
        private ManagerServiceBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ManagerServiceBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagerServiceBlockingStub(channel, callOptions);
        }

        /**
         */
        public org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse appendEntries(org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getAppendEntriesMethod(), getCallOptions(), request);
        }

        /**
         */
        public org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse voteFor(org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getVoteForMethod(), getCallOptions(), request);
        }

        /**
         */
        public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse jobShutdown(org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getJobShutdownMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class ManagerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ManagerServiceFutureStub> {
        private ManagerServiceFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ManagerServiceFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagerServiceFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse> appendEntries(
                org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getAppendEntriesMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse> voteFor(
                org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getVoteForMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse> jobShutdown(
                org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getJobShutdownMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final ManagerServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(ManagerServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_APPEND_ENTRIES:
                    serviceImpl.appendEntries((org.bupt.fedraft.rpc.manager.message.AppendEntriesRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.AppendEntriesResponse>) responseObserver);
                    break;
                case METHODID_VOTE_FOR:
                    serviceImpl.voteFor((org.bupt.fedraft.rpc.manager.message.ManagerVoteRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.ManagerVoteResponse>) responseObserver);
                    break;
                case METHODID_JOB_SHUTDOWN:
                    serviceImpl.jobShutdown((org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse>) responseObserver);
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
                case METHODID_JOB_SUBMIT:
                    return (io.grpc.stub.StreamObserver<Req>) serviceImpl.jobSubmit(
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.manager.message.JobSubmitResponse>) responseObserver);
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class ManagerServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        ManagerServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return org.bupt.fedraft.rpc.manager.service.ManagerServiceOuterClass.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ManagerService");
        }
    }

    private static final class ManagerServiceFileDescriptorSupplier
            extends ManagerServiceBaseDescriptorSupplier {
        ManagerServiceFileDescriptorSupplier() {
        }
    }

    private static final class ManagerServiceMethodDescriptorSupplier
            extends ManagerServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        ManagerServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}

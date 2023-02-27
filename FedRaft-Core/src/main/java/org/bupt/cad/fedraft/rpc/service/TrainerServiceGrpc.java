package org.bupt.cad.fedraft.rpc.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 模型训练模块服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.1)",
    comments = "Source: fedraft_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TrainerServiceGrpc {

    private static final int METHODID_APPEND_LOG = 0;

    public static final String SERVICE_NAME = "fedraft.TrainerService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest,
            org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendStreamLogMethod;
    private static final int METHODID_PULL_LOG = 1;
    private static final int METHODID_APPEND_STREAM_LOG = 2;
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest,
            org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendLogMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogPullRequest,
            org.bupt.cad.fedraft.rpc.message.LogPullResponse> getPullLogMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private TrainerServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "AppendStreamLog",
            requestType = org.bupt.cad.fedraft.rpc.message.LogRequest.class,
            responseType = org.bupt.cad.fedraft.rpc.message.LogResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
    public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest,
            org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendStreamLogMethod() {
        io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogRequest, org.bupt.cad.fedraft.rpc.message.LogResponse> getAppendStreamLogMethod;
        if ((getAppendStreamLogMethod = TrainerServiceGrpc.getAppendStreamLogMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getAppendStreamLogMethod = TrainerServiceGrpc.getAppendStreamLogMethod) == null) {
            TrainerServiceGrpc.getAppendStreamLogMethod = getAppendStreamLogMethod =
                    io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.LogRequest, org.bupt.cad.fedraft.rpc.message.LogResponse>newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendStreamLog"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                    org.bupt.cad.fedraft.rpc.message.LogRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                    org.bupt.cad.fedraft.rpc.message.LogResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("AppendStreamLog"))
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
        if ((getAppendLogMethod = TrainerServiceGrpc.getAppendLogMethod) == null) {
            synchronized (TrainerServiceGrpc.class) {
                if ((getAppendLogMethod = TrainerServiceGrpc.getAppendLogMethod) == null) {
                    TrainerServiceGrpc.getAppendLogMethod = getAppendLogMethod =
                            io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.LogRequest, org.bupt.cad.fedraft.rpc.message.LogResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendLog"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.LogRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.LogResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("AppendLog"))
                                    .build();
                }
            }
        }
        return getAppendLogMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "PullLog",
            requestType = org.bupt.cad.fedraft.rpc.message.LogPullRequest.class,
            responseType = org.bupt.cad.fedraft.rpc.message.LogPullResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
    public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogPullRequest,
            org.bupt.cad.fedraft.rpc.message.LogPullResponse> getPullLogMethod() {
        io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.LogPullRequest, org.bupt.cad.fedraft.rpc.message.LogPullResponse> getPullLogMethod;
        if ((getPullLogMethod = TrainerServiceGrpc.getPullLogMethod) == null) {
            synchronized (TrainerServiceGrpc.class) {
                if ((getPullLogMethod = TrainerServiceGrpc.getPullLogMethod) == null) {
                    TrainerServiceGrpc.getPullLogMethod = getPullLogMethod =
                            io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.LogPullRequest, org.bupt.cad.fedraft.rpc.message.LogPullResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PullLog"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.LogPullRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.cad.fedraft.rpc.message.LogPullResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("PullLog"))
                                    .build();
                }
            }
        }
        return getPullLogMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static TrainerServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<TrainerServiceStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<TrainerServiceStub>() {
                    @java.lang.Override
                    public TrainerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new TrainerServiceStub(channel, callOptions);
                    }
                };
        return TrainerServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static TrainerServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<TrainerServiceBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<TrainerServiceBlockingStub>() {
                    @java.lang.Override
                    public TrainerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new TrainerServiceBlockingStub(channel, callOptions);
                    }
                };
        return TrainerServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static TrainerServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<TrainerServiceFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<TrainerServiceFutureStub>() {
                    @java.lang.Override
                    public TrainerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new TrainerServiceFutureStub(channel, callOptions);
                    }
                };
        return TrainerServiceFutureStub.newStub(factory, channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (TrainerServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new TrainerServiceFileDescriptorSupplier())
                            .addMethod(getAppendStreamLogMethod())
                            .addMethod(getAppendLogMethod())
                            .addMethod(getPullLogMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     * <pre>
     * 模型训练模块服务
     * </pre>
   */
  public static abstract class TrainerServiceImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         * Raft 日志追加通信
         * </pre>
         */
        public io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogRequest> appendStreamLog(
                io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse> responseObserver) {
            return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAppendStreamLogMethod(), responseObserver);
        }

        /**
         *
         */
        public void appendLog(org.bupt.cad.fedraft.rpc.message.LogRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAppendLogMethod(), responseObserver);
        }

        /**
         *
         */
        public void pullLog(org.bupt.cad.fedraft.rpc.message.LogPullRequest request,
                            io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogPullResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPullLogMethod(), responseObserver);
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
                            getPullLogMethod(),
                            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                                    new MethodHandlers<
                                            org.bupt.cad.fedraft.rpc.message.LogPullRequest,
                                            org.bupt.cad.fedraft.rpc.message.LogPullResponse>(
                                            this, METHODID_PULL_LOG)))
                    .build();
        }
    }

    /**
     * <pre>
     * 模型训练模块服务
     * </pre>
     */
    public static final class TrainerServiceStub extends io.grpc.stub.AbstractAsyncStub<TrainerServiceStub> {
        private TrainerServiceStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TrainerServiceStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TrainerServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * Raft 日志追加通信
         * </pre>
         */
        public io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogRequest> appendStreamLog(
                io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse> responseObserver) {
            return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
                    getChannel().newCall(getAppendStreamLogMethod(), getCallOptions()), responseObserver);
        }

        /**
         *
         */
        public void appendLog(org.bupt.cad.fedraft.rpc.message.LogRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getAppendLogMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void pullLog(org.bupt.cad.fedraft.rpc.message.LogPullRequest request,
                            io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogPullResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncServerStreamingCall(
                    getChannel().newCall(getPullLogMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * <pre>
     * 模型训练模块服务
     * </pre>
     */
    public static final class TrainerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TrainerServiceBlockingStub> {
        private TrainerServiceBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TrainerServiceBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TrainerServiceBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public org.bupt.cad.fedraft.rpc.message.LogResponse appendLog(org.bupt.cad.fedraft.rpc.message.LogRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getAppendLogMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public java.util.Iterator<org.bupt.cad.fedraft.rpc.message.LogPullResponse> pullLog(
                org.bupt.cad.fedraft.rpc.message.LogPullRequest request) {
            return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
                    getChannel(), getPullLogMethod(), getCallOptions(), request);
        }
    }

    /**
     * <pre>
     * 模型训练模块服务
     * </pre>
     */
    public static final class TrainerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TrainerServiceFutureStub> {
        private TrainerServiceFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TrainerServiceFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TrainerServiceFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.LogResponse> appendLog(
                org.bupt.cad.fedraft.rpc.message.LogRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getAppendLogMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final TrainerServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(TrainerServiceImplBase serviceImpl, int methodId) {
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
                case METHODID_PULL_LOG:
                    serviceImpl.pullLog((org.bupt.cad.fedraft.rpc.message.LogPullRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.LogPullResponse>) responseObserver);
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

    private static abstract class TrainerServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        TrainerServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return org.bupt.cad.fedraft.rpc.service.FedraftService.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("TrainerService");
        }
    }

    private static final class TrainerServiceFileDescriptorSupplier
            extends TrainerServiceBaseDescriptorSupplier {
        TrainerServiceFileDescriptorSupplier() {
        }
    }

    private static final class TrainerServiceMethodDescriptorSupplier
            extends TrainerServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        TrainerServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
    }
  }
}

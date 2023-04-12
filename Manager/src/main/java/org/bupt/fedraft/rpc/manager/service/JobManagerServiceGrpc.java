package org.bupt.fedraft.rpc.manager.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.50.1)",
        comments = "Source: manager_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JobManagerServiceGrpc {

    public static final String SERVICE_NAME = "fedraft.JobManagerService";
    private static final int METHODID_APPEND_LOG = 0;
    private static final int METHODID_APPEND_MODELS = 1;
    private static final int METHODID_JOB_VOTE = 2;
    private static final int METHODID_PULL_MODEL = 3;
    private static final int METHODID_PUSH_MODEL = 4;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest,
            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> getAppendLogMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest,
            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> getAppendModelsMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest,
            org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse> getJobVoteMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest,
            org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse> getPullModelMethod;
    private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest,
            org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse> getPushModelMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private JobManagerServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "AppendLog",
            requestType = org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.class,
            responseType = org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest,
            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> getAppendLogMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest, org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> getAppendLogMethod;
        if ((getAppendLogMethod = JobManagerServiceGrpc.getAppendLogMethod) == null) {
            synchronized (JobManagerServiceGrpc.class) {
                if ((getAppendLogMethod = JobManagerServiceGrpc.getAppendLogMethod) == null) {
                    JobManagerServiceGrpc.getAppendLogMethod = getAppendLogMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest, org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendLog"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new JobManagerServiceMethodDescriptorSupplier("AppendLog"))
                                    .build();
                }
            }
        }
        return getAppendLogMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "AppendModels",
            requestType = org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.class,
            responseType = org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest,
            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> getAppendModelsMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest, org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> getAppendModelsMethod;
        if ((getAppendModelsMethod = JobManagerServiceGrpc.getAppendModelsMethod) == null) {
            synchronized (JobManagerServiceGrpc.class) {
                if ((getAppendModelsMethod = JobManagerServiceGrpc.getAppendModelsMethod) == null) {
                    JobManagerServiceGrpc.getAppendModelsMethod = getAppendModelsMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest, org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AppendModels"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new JobManagerServiceMethodDescriptorSupplier("AppendModels"))
                                    .build();
                }
            }
        }
        return getAppendModelsMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "JobVote",
            requestType = org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest.class,
            responseType = org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest,
            org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse> getJobVoteMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest, org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse> getJobVoteMethod;
        if ((getJobVoteMethod = JobManagerServiceGrpc.getJobVoteMethod) == null) {
            synchronized (JobManagerServiceGrpc.class) {
                if ((getJobVoteMethod = JobManagerServiceGrpc.getJobVoteMethod) == null) {
                    JobManagerServiceGrpc.getJobVoteMethod = getJobVoteMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest, org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JobVote"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new JobManagerServiceMethodDescriptorSupplier("JobVote"))
                                    .build();
                }
            }
        }
        return getJobVoteMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "PullModel",
            requestType = org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.class,
            responseType = org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest,
            org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse> getPullModelMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse> getPullModelMethod;
        if ((getPullModelMethod = JobManagerServiceGrpc.getPullModelMethod) == null) {
            synchronized (JobManagerServiceGrpc.class) {
                if ((getPullModelMethod = JobManagerServiceGrpc.getPullModelMethod) == null) {
                    JobManagerServiceGrpc.getPullModelMethod = getPullModelMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest, org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PullModel"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new JobManagerServiceMethodDescriptorSupplier("PullModel"))
                                    .build();
                }
            }
        }
        return getPullModelMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "PushModel",
            requestType = org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.class,
            responseType = org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
    public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest,
            org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse> getPushModelMethod() {
        io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest, org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse> getPushModelMethod;
        if ((getPushModelMethod = JobManagerServiceGrpc.getPushModelMethod) == null) {
            synchronized (JobManagerServiceGrpc.class) {
                if ((getPushModelMethod = JobManagerServiceGrpc.getPushModelMethod) == null) {
                    JobManagerServiceGrpc.getPushModelMethod = getPushModelMethod =
                            io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest, org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PushModel"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new JobManagerServiceMethodDescriptorSupplier("PushModel"))
                                    .build();
                }
            }
        }
        return getPushModelMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static JobManagerServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<JobManagerServiceStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<JobManagerServiceStub>() {
                    @java.lang.Override
                    public JobManagerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new JobManagerServiceStub(channel, callOptions);
                    }
                };
        return JobManagerServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static JobManagerServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<JobManagerServiceBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<JobManagerServiceBlockingStub>() {
                    @java.lang.Override
                    public JobManagerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new JobManagerServiceBlockingStub(channel, callOptions);
                    }
                };
        return JobManagerServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static JobManagerServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<JobManagerServiceFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<JobManagerServiceFutureStub>() {
                    @java.lang.Override
                    public JobManagerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new JobManagerServiceFutureStub(channel, callOptions);
                    }
                };
        return JobManagerServiceFutureStub.newStub(factory, channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (JobManagerServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new JobManagerServiceFileDescriptorSupplier())
                            .addMethod(getAppendLogMethod())
                            .addMethod(getAppendModelsMethod())
                            .addMethod(getJobVoteMethod())
                            .addMethod(getPullModelMethod())
                            .addMethod(getPushModelMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     */
    public static abstract class JobManagerServiceImplBase implements io.grpc.BindableService {

        /**
         */
        public void appendLog(org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAppendLogMethod(), responseObserver);
        }

        /**
         */
        public void appendModels(org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest request,
                                 io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAppendModelsMethod(), responseObserver);
        }

        /**
         */
        public void jobVote(org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest request,
                            io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJobVoteMethod(), responseObserver);
        }

        /**
         */
        public void pullModel(org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPullModelMethod(), responseObserver);
        }

        /**
         */
        public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest> pushModel(
                io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse> responseObserver) {
            return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPushModelMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getAppendLogMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest,
                                            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse>(
                                            this, METHODID_APPEND_LOG)))
                    .addMethod(
                            getAppendModelsMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest,
                                            org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse>(
                                            this, METHODID_APPEND_MODELS)))
                    .addMethod(
                            getJobVoteMethod(),
                            io.grpc.stub.ServerCalls.asyncUnaryCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest,
                                            org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse>(
                                            this, METHODID_JOB_VOTE)))
                    .addMethod(
                            getPullModelMethod(),
                            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest,
                                            org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse>(
                                            this, METHODID_PULL_MODEL)))
                    .addMethod(
                            getPushModelMethod(),
                            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
                                    new MethodHandlers<
                                            org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest,
                                            org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse>(
                                            this, METHODID_PUSH_MODEL)))
                    .build();
        }
    }

    /**
     */
    public static final class JobManagerServiceStub extends io.grpc.stub.AbstractAsyncStub<JobManagerServiceStub> {
        private JobManagerServiceStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected JobManagerServiceStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new JobManagerServiceStub(channel, callOptions);
        }

        /**
         */
        public void appendLog(org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getAppendLogMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void appendModels(org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest request,
                                 io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getAppendModelsMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void jobVote(org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest request,
                            io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                    getChannel().newCall(getJobVoteMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void pullModel(org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest request,
                              io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncServerStreamingCall(
                    getChannel().newCall(getPullModelMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelRequest> pushModel(
                io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse> responseObserver) {
            return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
                    getChannel().newCall(getPushModelMethod(), getCallOptions()), responseObserver);
        }
    }

    /**
     */
    public static final class JobManagerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<JobManagerServiceBlockingStub> {
        private JobManagerServiceBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected JobManagerServiceBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new JobManagerServiceBlockingStub(channel, callOptions);
        }

        /**
         */
        public org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse appendLog(org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getAppendLogMethod(), getCallOptions(), request);
        }

        /**
         */
        public org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse appendModels(org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getAppendModelsMethod(), getCallOptions(), request);
        }

        /**
         */
        public org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse jobVote(org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                    getChannel(), getJobVoteMethod(), getCallOptions(), request);
        }

        /**
         */
        public java.util.Iterator<org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse> pullModel(
                org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest request) {
            return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
                    getChannel(), getPullModelMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static final class JobManagerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<JobManagerServiceFutureStub> {
        private JobManagerServiceFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected JobManagerServiceFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new JobManagerServiceFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> appendLog(
                org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getAppendLogMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> appendModels(
                org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getAppendModelsMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse> jobVote(
                org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                    getChannel().newCall(getJobVoteMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final JobManagerServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(JobManagerServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_APPEND_LOG:
                    serviceImpl.appendLog((org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse>) responseObserver);
                    break;
                case METHODID_APPEND_MODELS:
                    serviceImpl.appendModels((org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse>) responseObserver);
                    break;
                case METHODID_JOB_VOTE:
                    serviceImpl.jobVote((org.bupt.fedraft.rpc.jobmanager.message.JobVoteRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse>) responseObserver);
                    break;
                case METHODID_PULL_MODEL:
                    serviceImpl.pullModel((org.bupt.fedraft.rpc.jobmanager.message.JobPullModelRequest) request,
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobPullModelResponse>) responseObserver);
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
                case METHODID_PUSH_MODEL:
                    return (io.grpc.stub.StreamObserver<Req>) serviceImpl.pushModel(
                            (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.jobmanager.message.JobPushModelResponse>) responseObserver);
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class JobManagerServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        JobManagerServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return org.bupt.fedraft.rpc.manager.service.ManagerServiceOuterClass.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("JobManagerService");
        }
    }

    private static final class JobManagerServiceFileDescriptorSupplier
            extends JobManagerServiceBaseDescriptorSupplier {
        JobManagerServiceFileDescriptorSupplier() {
        }
    }

    private static final class JobManagerServiceMethodDescriptorSupplier
            extends JobManagerServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        JobManagerServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}

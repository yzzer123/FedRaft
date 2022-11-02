package org.bupt.cad.fedraft.rpc.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 选举模块服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.1)",
    comments = "Source: fedraft_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ManagerServiceGrpc {

  private static final int METHODID_HEARTBEAT = 0;

  public static final String SERVICE_NAME = "fedraft.ManagerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.HeartbeatRequest,
      org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> getHeartbeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Heartbeat",
      requestType = org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.class,
      responseType = org.bupt.cad.fedraft.rpc.message.HeartbeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.HeartbeatRequest,
      org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> getHeartbeatMethod() {
    io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.HeartbeatRequest, org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> getHeartbeatMethod;
    if ((getHeartbeatMethod = ManagerServiceGrpc.getHeartbeatMethod) == null) {
      synchronized (ManagerServiceGrpc.class) {
        if ((getHeartbeatMethod = ManagerServiceGrpc.getHeartbeatMethod) == null) {
          ManagerServiceGrpc.getHeartbeatMethod = getHeartbeatMethod =
              io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.HeartbeatRequest, org.bupt.cad.fedraft.rpc.message.HeartbeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Heartbeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.cad.fedraft.rpc.message.HeartbeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.cad.fedraft.rpc.message.HeartbeatResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagerServiceMethodDescriptorSupplier("Heartbeat"))
              .build();
        }
      }
    }
    return getHeartbeatMethod;
  }
  private static final int METHODID_TRIGGER_ELECTION = 1;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TriggerElection",
      requestType = org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.class,
      responseType = org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest,
      org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> getTriggerElectionMethod() {
    io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest, org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> getTriggerElectionMethod;
    if ((getTriggerElectionMethod = ManagerServiceGrpc.getTriggerElectionMethod) == null) {
      synchronized (ManagerServiceGrpc.class) {
        if ((getTriggerElectionMethod = ManagerServiceGrpc.getTriggerElectionMethod) == null) {
          ManagerServiceGrpc.getTriggerElectionMethod = getTriggerElectionMethod =
              io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest, org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TriggerElection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagerServiceMethodDescriptorSupplier("TriggerElection"))
              .build();
        }
      }
    }
    return getTriggerElectionMethod;
  }
  private static final int METHODID_REQUEST_VOTE = 2;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestVote",
      requestType = org.bupt.cad.fedraft.rpc.message.VoteRequest.class,
      responseType = org.bupt.cad.fedraft.rpc.message.VoteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.VoteRequest,
      org.bupt.cad.fedraft.rpc.message.VoteResponse> getRequestVoteMethod() {
    io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.VoteRequest, org.bupt.cad.fedraft.rpc.message.VoteResponse> getRequestVoteMethod;
    if ((getRequestVoteMethod = ManagerServiceGrpc.getRequestVoteMethod) == null) {
      synchronized (ManagerServiceGrpc.class) {
        if ((getRequestVoteMethod = ManagerServiceGrpc.getRequestVoteMethod) == null) {
          ManagerServiceGrpc.getRequestVoteMethod = getRequestVoteMethod =
              io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.VoteRequest, org.bupt.cad.fedraft.rpc.message.VoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestVote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.cad.fedraft.rpc.message.VoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.cad.fedraft.rpc.message.VoteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagerServiceMethodDescriptorSupplier("RequestVote"))
              .build();
        }
      }
    }
    return getRequestVoteMethod;
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

  /**
   * <pre>
   * 选举模块服务
   * </pre>
   */
  public static abstract class ManagerServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 心跳通信
     * </pre>
     */
    public void heartbeat(org.bupt.cad.fedraft.rpc.message.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHeartbeatMethod(), responseObserver);
    }

    /**
     * <pre>
     * 触发所有节点超时重新选举
     * </pre>
     */
    public void triggerElection(org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest request,
        io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTriggerElectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * 请求投票
     * </pre>
     */
    public void requestVote(org.bupt.cad.fedraft.rpc.message.VoteRequest request,
        io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.VoteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestVoteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHeartbeatMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.bupt.cad.fedraft.rpc.message.HeartbeatRequest,
                org.bupt.cad.fedraft.rpc.message.HeartbeatResponse>(
                  this, METHODID_HEARTBEAT)))
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
   * <pre>
   * 选举模块服务
   * </pre>
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
     * <pre>
     * 心跳通信
     * </pre>
     */
    public void heartbeat(org.bupt.cad.fedraft.rpc.message.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHeartbeatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 触发所有节点超时重新选举
     * </pre>
     */
    public void triggerElection(org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest request,
        io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTriggerElectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 请求投票
     * </pre>
     */
    public void requestVote(org.bupt.cad.fedraft.rpc.message.VoteRequest request,
        io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.VoteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestVoteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 选举模块服务
   * </pre>
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
     * <pre>
     * 心跳通信
     * </pre>
     */
    public org.bupt.cad.fedraft.rpc.message.HeartbeatResponse heartbeat(org.bupt.cad.fedraft.rpc.message.HeartbeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHeartbeatMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 触发所有节点超时重新选举
     * </pre>
     */
    public org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse triggerElection(org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTriggerElectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 请求投票
     * </pre>
     */
    public org.bupt.cad.fedraft.rpc.message.VoteResponse requestVote(org.bupt.cad.fedraft.rpc.message.VoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestVoteMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 选举模块服务
   * </pre>
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
     * <pre>
     * 心跳通信
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.HeartbeatResponse> heartbeat(
        org.bupt.cad.fedraft.rpc.message.HeartbeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHeartbeatMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 触发所有节点超时重新选举
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> triggerElection(
        org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTriggerElectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 请求投票
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.VoteResponse> requestVote(
        org.bupt.cad.fedraft.rpc.message.VoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestVoteMethod(), getCallOptions()), request);
    }
  }
  private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.TriggerElectionRequest,
      org.bupt.cad.fedraft.rpc.message.TriggerElectionResponse> getTriggerElectionMethod;
  private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.VoteRequest,
      org.bupt.cad.fedraft.rpc.message.VoteResponse> getRequestVoteMethod;
  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

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
        case METHODID_HEARTBEAT:
          serviceImpl.heartbeat((org.bupt.cad.fedraft.rpc.message.HeartbeatRequest) request,
              (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.HeartbeatResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ManagerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManagerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.bupt.cad.fedraft.rpc.service.FedraftService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManagerService");
    }
  }

  private static final class ManagerServiceFileDescriptorSupplier
      extends ManagerServiceBaseDescriptorSupplier {
    ManagerServiceFileDescriptorSupplier() {}
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

  private ManagerServiceGrpc() {}

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ManagerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ManagerServiceFileDescriptorSupplier())
              .addMethod(getHeartbeatMethod())
              .addMethod(getTriggerElectionMethod())
              .addMethod(getRequestVoteMethod())
              .build();
        }
      }
    }
    return result;
  }
}

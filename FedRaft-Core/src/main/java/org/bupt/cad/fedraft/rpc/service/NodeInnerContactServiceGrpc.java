package org.bupt.cad.fedraft.rpc.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 节点内部进程通信
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.1)",
    comments = "Source: fedraft_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NodeInnerContactServiceGrpc {

  private static final int METHODID_SYNC_WITH_TRAINER = 0;

  public static final String SERVICE_NAME = "fedraft.NodeInnerContactService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest,
      org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> getSyncWithTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SyncWithTrainer",
      requestType = org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest.class,
      responseType = org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest,
      org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> getSyncWithTrainerMethod() {
    io.grpc.MethodDescriptor<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest, org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> getSyncWithTrainerMethod;
    if ((getSyncWithTrainerMethod = NodeInnerContactServiceGrpc.getSyncWithTrainerMethod) == null) {
      synchronized (NodeInnerContactServiceGrpc.class) {
        if ((getSyncWithTrainerMethod = NodeInnerContactServiceGrpc.getSyncWithTrainerMethod) == null) {
          NodeInnerContactServiceGrpc.getSyncWithTrainerMethod = getSyncWithTrainerMethod =
              io.grpc.MethodDescriptor.<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest, org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SyncWithTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NodeInnerContactServiceMethodDescriptorSupplier("SyncWithTrainer"))
              .build();
        }
      }
    }
    return getSyncWithTrainerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NodeInnerContactServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeInnerContactServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeInnerContactServiceStub>() {
        @java.lang.Override
        public NodeInnerContactServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeInnerContactServiceStub(channel, callOptions);
        }
      };
    return NodeInnerContactServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NodeInnerContactServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeInnerContactServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeInnerContactServiceBlockingStub>() {
        @java.lang.Override
        public NodeInnerContactServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeInnerContactServiceBlockingStub(channel, callOptions);
        }
      };
    return NodeInnerContactServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NodeInnerContactServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeInnerContactServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeInnerContactServiceFutureStub>() {
        @java.lang.Override
        public NodeInnerContactServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeInnerContactServiceFutureStub(channel, callOptions);
        }
      };
    return NodeInnerContactServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 节点内部进程通信
   * </pre>
   */
  public static abstract class NodeInnerContactServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void syncWithTrainer(org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest request,
        io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSyncWithTrainerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSyncWithTrainerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest,
                org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse>(
                  this, METHODID_SYNC_WITH_TRAINER)))
          .build();
    }
  }

  /**
   * <pre>
   * 节点内部进程通信
   * </pre>
   */
  public static final class NodeInnerContactServiceStub extends io.grpc.stub.AbstractAsyncStub<NodeInnerContactServiceStub> {
    private NodeInnerContactServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeInnerContactServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeInnerContactServiceStub(channel, callOptions);
    }

    /**
     */
    public void syncWithTrainer(org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest request,
        io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSyncWithTrainerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 节点内部进程通信
   * </pre>
   */
  public static final class NodeInnerContactServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NodeInnerContactServiceBlockingStub> {
    private NodeInnerContactServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeInnerContactServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeInnerContactServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse syncWithTrainer(org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSyncWithTrainerMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 节点内部进程通信
   * </pre>
   */
  public static final class NodeInnerContactServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NodeInnerContactServiceFutureStub> {
    private NodeInnerContactServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeInnerContactServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeInnerContactServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse> syncWithTrainer(
        org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSyncWithTrainerMethod(), getCallOptions()), request);
    }
  }
  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NodeInnerContactServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NodeInnerContactServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SYNC_WITH_TRAINER:
          serviceImpl.syncWithTrainer((org.bupt.cad.fedraft.rpc.message.SyncWithTrainerRequest) request,
              (io.grpc.stub.StreamObserver<org.bupt.cad.fedraft.rpc.message.SyncWithTrainerResponse>) responseObserver);
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

  private static abstract class NodeInnerContactServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NodeInnerContactServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.bupt.cad.fedraft.rpc.service.FedraftService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NodeInnerContactService");
    }
  }

  private static final class NodeInnerContactServiceFileDescriptorSupplier
      extends NodeInnerContactServiceBaseDescriptorSupplier {
    NodeInnerContactServiceFileDescriptorSupplier() {}
  }

  private static final class NodeInnerContactServiceMethodDescriptorSupplier
      extends NodeInnerContactServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NodeInnerContactServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private NodeInnerContactServiceGrpc() {}

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NodeInnerContactServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NodeInnerContactServiceFileDescriptorSupplier())
              .addMethod(getSyncWithTrainerMethod())
              .build();
        }
      }
    }
    return result;
  }
}

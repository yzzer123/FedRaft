package org.bupt.fedraft.rpc.trainer.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Trainer服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.1)",
    comments = "Source: trainer_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TrainerServiceGrpc {

  private TrainerServiceGrpc() {}

  public static final String SERVICE_NAME = "fedraft.TrainerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.TrainRequest,
      org.bupt.fedraft.rpc.trainer.message.TrainResponse> getTrainModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrainModel",
      requestType = org.bupt.fedraft.rpc.trainer.message.TrainRequest.class,
      responseType = org.bupt.fedraft.rpc.trainer.message.TrainResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.TrainRequest,
      org.bupt.fedraft.rpc.trainer.message.TrainResponse> getTrainModelMethod() {
    io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.TrainRequest, org.bupt.fedraft.rpc.trainer.message.TrainResponse> getTrainModelMethod;
    if ((getTrainModelMethod = TrainerServiceGrpc.getTrainModelMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getTrainModelMethod = TrainerServiceGrpc.getTrainModelMethod) == null) {
          TrainerServiceGrpc.getTrainModelMethod = getTrainModelMethod =
              io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.trainer.message.TrainRequest, org.bupt.fedraft.rpc.trainer.message.TrainResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TrainModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.fedraft.rpc.trainer.message.TrainRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.fedraft.rpc.trainer.message.TrainResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("TrainModel"))
              .build();
        }
      }
    }
    return getTrainModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.PushModelRequest,
      org.bupt.fedraft.rpc.trainer.message.PushModelResponse> getPushModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PushModel",
      requestType = org.bupt.fedraft.rpc.trainer.message.PushModelRequest.class,
      responseType = org.bupt.fedraft.rpc.trainer.message.PushModelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.PushModelRequest,
      org.bupt.fedraft.rpc.trainer.message.PushModelResponse> getPushModelMethod() {
    io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.PushModelRequest, org.bupt.fedraft.rpc.trainer.message.PushModelResponse> getPushModelMethod;
    if ((getPushModelMethod = TrainerServiceGrpc.getPushModelMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getPushModelMethod = TrainerServiceGrpc.getPushModelMethod) == null) {
          TrainerServiceGrpc.getPushModelMethod = getPushModelMethod =
              io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.trainer.message.PushModelRequest, org.bupt.fedraft.rpc.trainer.message.PushModelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PushModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.fedraft.rpc.trainer.message.PushModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.fedraft.rpc.trainer.message.PushModelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("PushModel"))
              .build();
        }
      }
    }
    return getPushModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.MergeRequest,
      org.bupt.fedraft.rpc.trainer.message.MergeResponse> getMergeModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MergeModel",
      requestType = org.bupt.fedraft.rpc.trainer.message.MergeRequest.class,
      responseType = org.bupt.fedraft.rpc.trainer.message.MergeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.MergeRequest,
      org.bupt.fedraft.rpc.trainer.message.MergeResponse> getMergeModelMethod() {
    io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.MergeRequest, org.bupt.fedraft.rpc.trainer.message.MergeResponse> getMergeModelMethod;
    if ((getMergeModelMethod = TrainerServiceGrpc.getMergeModelMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getMergeModelMethod = TrainerServiceGrpc.getMergeModelMethod) == null) {
          TrainerServiceGrpc.getMergeModelMethod = getMergeModelMethod =
              io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.trainer.message.MergeRequest, org.bupt.fedraft.rpc.trainer.message.MergeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MergeModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.fedraft.rpc.trainer.message.MergeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.fedraft.rpc.trainer.message.MergeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("MergeModel"))
              .build();
        }
      }
    }
    return getMergeModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.InitModelRequest,
      org.bupt.fedraft.rpc.trainer.message.InitModelResponse> getInitModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitModel",
      requestType = org.bupt.fedraft.rpc.trainer.message.InitModelRequest.class,
      responseType = org.bupt.fedraft.rpc.trainer.message.InitModelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.InitModelRequest,
      org.bupt.fedraft.rpc.trainer.message.InitModelResponse> getInitModelMethod() {
    io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.trainer.message.InitModelRequest, org.bupt.fedraft.rpc.trainer.message.InitModelResponse> getInitModelMethod;
    if ((getInitModelMethod = TrainerServiceGrpc.getInitModelMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getInitModelMethod = TrainerServiceGrpc.getInitModelMethod) == null) {
          TrainerServiceGrpc.getInitModelMethod = getInitModelMethod =
              io.grpc.MethodDescriptor.<org.bupt.fedraft.rpc.trainer.message.InitModelRequest, org.bupt.fedraft.rpc.trainer.message.InitModelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InitModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.fedraft.rpc.trainer.message.InitModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.bupt.fedraft.rpc.trainer.message.InitModelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("InitModel"))
              .build();
        }
      }
    }
    return getInitModelMethod;
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

  /**
   * <pre>
   * Trainer服务
   * </pre>
   */
  public static abstract class TrainerServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 训练模型
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.TrainRequest> trainModel(
        io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.TrainResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getTrainModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * 发送待合并模型
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.PushModelRequest> pushModel(
        io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.PushModelResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPushModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * 请求合并模型
     * </pre>
     */
    public void mergeModel(org.bupt.fedraft.rpc.trainer.message.MergeRequest request,
        io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.MergeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMergeModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * 初始化模型
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.InitModelRequest> initModel(
        io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.InitModelResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getInitModelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTrainModelMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                org.bupt.fedraft.rpc.trainer.message.TrainRequest,
                org.bupt.fedraft.rpc.trainer.message.TrainResponse>(
                  this, METHODID_TRAIN_MODEL)))
          .addMethod(
            getPushModelMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                org.bupt.fedraft.rpc.trainer.message.PushModelRequest,
                org.bupt.fedraft.rpc.trainer.message.PushModelResponse>(
                  this, METHODID_PUSH_MODEL)))
          .addMethod(
            getMergeModelMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.bupt.fedraft.rpc.trainer.message.MergeRequest,
                org.bupt.fedraft.rpc.trainer.message.MergeResponse>(
                  this, METHODID_MERGE_MODEL)))
          .addMethod(
            getInitModelMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                org.bupt.fedraft.rpc.trainer.message.InitModelRequest,
                org.bupt.fedraft.rpc.trainer.message.InitModelResponse>(
                  this, METHODID_INIT_MODEL)))
          .build();
    }
  }

  /**
   * <pre>
   * Trainer服务
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
     * 训练模型
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.TrainRequest> trainModel(
        io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.TrainResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getTrainModelMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 发送待合并模型
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.PushModelRequest> pushModel(
        io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.PushModelResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getPushModelMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 请求合并模型
     * </pre>
     */
    public void mergeModel(org.bupt.fedraft.rpc.trainer.message.MergeRequest request,
        io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.MergeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMergeModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 初始化模型
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.InitModelRequest> initModel(
        io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.InitModelResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getInitModelMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Trainer服务
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
     * <pre>
     * 请求合并模型
     * </pre>
     */
    public java.util.Iterator<org.bupt.fedraft.rpc.trainer.message.MergeResponse> mergeModel(
        org.bupt.fedraft.rpc.trainer.message.MergeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMergeModelMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Trainer服务
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
  }

  private static final int METHODID_MERGE_MODEL = 0;
  private static final int METHODID_TRAIN_MODEL = 1;
  private static final int METHODID_PUSH_MODEL = 2;
  private static final int METHODID_INIT_MODEL = 3;

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
        case METHODID_MERGE_MODEL:
          serviceImpl.mergeModel((org.bupt.fedraft.rpc.trainer.message.MergeRequest) request,
              (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.MergeResponse>) responseObserver);
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
        case METHODID_TRAIN_MODEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.trainModel(
              (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.TrainResponse>) responseObserver);
        case METHODID_PUSH_MODEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.pushModel(
              (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.PushModelResponse>) responseObserver);
        case METHODID_INIT_MODEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.initModel(
              (io.grpc.stub.StreamObserver<org.bupt.fedraft.rpc.trainer.message.InitModelResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TrainerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrainerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.bupt.fedraft.rpc.trainer.service.TrainerServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrainerService");
    }
  }

  private static final class TrainerServiceFileDescriptorSupplier
      extends TrainerServiceBaseDescriptorSupplier {
    TrainerServiceFileDescriptorSupplier() {}
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

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TrainerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrainerServiceFileDescriptorSupplier())
              .addMethod(getTrainModelMethod())
              .addMethod(getPushModelMethod())
              .addMethod(getMergeModelMethod())
              .addMethod(getInitModelMethod())
              .build();
        }
      }
    }
    return result;
  }
}

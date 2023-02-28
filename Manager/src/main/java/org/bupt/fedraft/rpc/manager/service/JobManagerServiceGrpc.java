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
  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogRequest,
          org.bupt.fedraft.rpc.jobmanager.message.AppendJobLogResponse> getAppendLogMethod;
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

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jobmanager_message.proto

package org.bupt.fedraft.rpc.jobmanager.message;

/**
 * Protobuf type {@code fedraft.JobShutdownResponse}
 */
public final class JobShutdownResponse extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.JobShutdownResponse)
        JobShutdownResponseOrBuilder {
  private static final long serialVersionUID = 0L;
  // @@protoc_insertion_point(class_scope:fedraft.JobShutdownResponse)
  private static final org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<JobShutdownResponse>
          PARSER = new com.google.protobuf.AbstractParser<JobShutdownResponse>() {
    @java.lang.Override
    public JobShutdownResponse parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  static {
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse();
  }

  private byte memoizedIsInitialized = -1;

  // Use JobShutdownResponse.newBuilder() to construct.
  private JobShutdownResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private JobShutdownResponse() {
  }

  public static com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownResponse_descriptor;
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<JobShutdownResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
          UnusedPrivateParameter unused) {
    return new JobShutdownResponse();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
  internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.class, org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.Builder.class);
  }

  @java.lang.Override
  public boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
          throws java.io.IOException {
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse other = (org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse) obj;

    return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
            ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<JobShutdownResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Protobuf type {@code fedraft.JobShutdownResponse}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:fedraft.JobShutdownResponse)
          org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponseOrBuilder {
    // Construct using org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.newBuilder()
    private Builder() {

    }

    private Builder(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownResponse_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.class, org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.Builder.class);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
    getDescriptorForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownResponse_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse build() {
      org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse buildPartial() {
      org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse result = new org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse(this);
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(
            com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(
            com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse) {
        return mergeFrom((org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse other) {
      if (other == org.bupt.fedraft.rpc.jobmanager.message.JobShutdownResponse.getDefaultInstance()) return this;
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          // default:
          if (tag == 0) {
            done = true;
          } else {
            if (!super.parseUnknownField(input, extensionRegistry, tag)) {
              done = true; // was an endgroup tag
            }
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    @java.lang.Override
    public Builder setUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public Builder mergeUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:fedraft.JobShutdownResponse)
  }

}


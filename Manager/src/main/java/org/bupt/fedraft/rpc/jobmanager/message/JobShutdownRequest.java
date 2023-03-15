// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jobmanager_message.proto

package org.bupt.fedraft.rpc.jobmanager.message;

/**
 * Protobuf type {@code fedraft.JobShutdownRequest}
 */
public final class JobShutdownRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.JobShutdownRequest)
        JobShutdownRequestOrBuilder {
    public static final int SOURCEID_FIELD_NUMBER = 1;

    // Use JobShutdownRequest.newBuilder() to construct.
    private JobShutdownRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private JobShutdownRequest() {
    }

    public static final int UUID_FIELD_NUMBER = 2;

    @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:fedraft.JobShutdownRequest)
    private static final org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<JobShutdownRequest>
            PARSER = new com.google.protobuf.AbstractParser<JobShutdownRequest>() {
        @java.lang.Override
        public JobShutdownRequest parsePartialFrom(
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
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest();
  }
  /**
   * <code>int64 sourceId = 1;</code>
   * @return The sourceId.
   */
  @java.lang.Override
  public long getSourceId() {
    return sourceId_;
  }

  private long sourceId_;
  private int uuid_;
  /**
   * <code>int32 uuid = 2;</code>
   * @return The uuid.
   */
  @java.lang.Override
  public int getUuid() {
    return uuid_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownRequest_descriptor;
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

  public static org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<JobShutdownRequest> parser() {
    return PARSER;
  }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new JobShutdownRequest();
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.class, org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.Builder.class);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (sourceId_ != 0L) {
            output.writeInt64(1, sourceId_);
        }
        if (uuid_ != 0) {
            output.writeInt32(2, uuid_);
        }
        getUnknownFields().writeTo(output);
    }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (sourceId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
                .computeInt64Size(1, sourceId_);
    }
    if (uuid_ != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeInt32Size(2, uuid_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
        return true;
    }
      if (!(obj instanceof org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest)) {
          return super.equals(obj);
      }
      org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest other = (org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest) obj;

      if (getSourceId()
              != other.getSourceId()) return false;
      if (getUuid()
              != other.getUuid()) return false;
      return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + SOURCEID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              getSourceId());
      hash = (37 * hash) + UUID_FIELD_NUMBER;
    hash = (53 * hash) + getUuid();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }

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
  public com.google.protobuf.Parser<JobShutdownRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    /**
     * Protobuf type {@code fedraft.JobShutdownRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:fedraft.JobShutdownRequest)
            org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequestOrBuilder {
        private long sourceId_;
        private int uuid_;

        // Construct using org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.newBuilder()
        private Builder() {

        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);

        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            sourceId_ = 0L;

            uuid_ = 0;

      return this;
    }

        public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownRequest_descriptor;
        }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest build() {
      org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest buildPartial() {
      org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest result = new org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest(this);
      result.sourceId_ = sourceId_;
      result.uuid_ = uuid_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.class, org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.Builder.class);
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobShutdownRequest_descriptor;
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
            if (other instanceof org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest) {
                return mergeFrom((org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest other) {
            if (other == org.bupt.fedraft.rpc.jobmanager.message.JobShutdownRequest.getDefaultInstance()) return this;
            if (other.getSourceId() != 0L) {
                setSourceId(other.getSourceId());
            }
            if (other.getUuid() != 0) {
                setUuid(other.getUuid());
            }
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
                    switch (tag) {
                        case 0:
                            done = true;
              break;
            case 8: {
              sourceId_ = input.readInt64();

              break;
            } // case 8
            case 16: {
              uuid_ = input.readInt32();

              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
                    } // switch (tag)
                } // while (!done)
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.unwrapIOException();
            } finally {
                onChanged();
            } // finally
            return this;
        }

        /**
         * <code>int64 sourceId = 1;</code>
         *
         * @return The sourceId.
         */
        @java.lang.Override
        public long getSourceId() {
            return sourceId_;
        }

        /**
         * <code>int64 sourceId = 1;</code>
         *
         * @param value The sourceId to set.
         * @return This builder for chaining.
         */
        public Builder setSourceId(long value) {

            sourceId_ = value;
            onChanged();
      return this;
    }

    /**
     * <code>int64 sourceId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSourceId() {

      sourceId_ = 0L;
      onChanged();
      return this;
    }
    /**
     * <code>int32 uuid = 2;</code>
     * @return The uuid.
     */
    @java.lang.Override
    public int getUuid() {
      return uuid_;
    }

    /**
     * <code>int32 uuid = 2;</code>
     * @param value The uuid to set.
     * @return This builder for chaining.
     */
    public Builder setUuid(int value) {

      uuid_ = value;
      onChanged();
      return this;
    }

        /**
         * <code>int32 uuid = 2;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearUuid() {

            uuid_ = 0;
            onChanged();
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


    // @@protoc_insertion_point(builder_scope:fedraft.JobShutdownRequest)
  }

}


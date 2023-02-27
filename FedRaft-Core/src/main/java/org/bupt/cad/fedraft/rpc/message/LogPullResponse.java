// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: log_message.proto

package org.bupt.cad.fedraft.rpc.message;

/**
 * Protobuf type {@code fedraft.LogPullResponse}
 */
public final class LogPullResponse extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.LogPullResponse)
        LogPullResponseOrBuilder {
    public static final int MODEL_CHUNK_FIELD_NUMBER = 1;
    public static final int MODEL_INDEX_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:fedraft.LogPullResponse)
    private static final org.bupt.cad.fedraft.rpc.message.LogPullResponse DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<LogPullResponse>
            PARSER = new com.google.protobuf.AbstractParser<LogPullResponse>() {
        @java.lang.Override
        public LogPullResponse parsePartialFrom(
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
        DEFAULT_INSTANCE = new org.bupt.cad.fedraft.rpc.message.LogPullResponse();
    }

    private com.google.protobuf.ByteString modelChunk_;
    private int modelIndex_;
    private byte memoizedIsInitialized = -1;

    // Use LogPullResponse.newBuilder() to construct.
    private LogPullResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private LogPullResponse() {
        modelChunk_ = com.google.protobuf.ByteString.EMPTY;
    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogPullResponse_descriptor;
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.cad.fedraft.rpc.message.LogPullResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<LogPullResponse> parser() {
        return PARSER;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new LogPullResponse();
    }

    @java.lang.Override
    public com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogPullResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        org.bupt.cad.fedraft.rpc.message.LogPullResponse.class, org.bupt.cad.fedraft.rpc.message.LogPullResponse.Builder.class);
    }

    /**
     * <pre>
     * 模型的序列化块
     * </pre>
     *
     * <code>bytes model_chunk = 1;</code>
     *
     * @return The modelChunk.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getModelChunk() {
        return modelChunk_;
    }

    /**
     * <code>uint32 model_index = 2;</code>
     *
     * @return The modelIndex.
     */
    @java.lang.Override
    public int getModelIndex() {
        return modelIndex_;
    }

    @java.lang.Override
    public boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(org.bupt.cad.fedraft.rpc.message.LogPullResponse prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (!modelChunk_.isEmpty()) {
            output.writeBytes(1, modelChunk_);
        }
        if (modelIndex_ != 0) {
            output.writeUInt32(2, modelIndex_);
        }
        getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (!modelChunk_.isEmpty()) {
            size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(1, modelChunk_);
        }
        if (modelIndex_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeUInt32Size(2, modelIndex_);
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
      if (!(obj instanceof org.bupt.cad.fedraft.rpc.message.LogPullResponse)) {
          return super.equals(obj);
      }
      org.bupt.cad.fedraft.rpc.message.LogPullResponse other = (org.bupt.cad.fedraft.rpc.message.LogPullResponse) obj;

      if (!getModelChunk()
              .equals(other.getModelChunk())) return false;
      if (getModelIndex()
              != other.getModelIndex()) return false;
      return getUnknownFields().equals(other.getUnknownFields());
  }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + MODEL_CHUNK_FIELD_NUMBER;
        hash = (53 * hash) + getModelChunk().hashCode();
        hash = (37 * hash) + MODEL_INDEX_FIELD_NUMBER;
        hash = (53 * hash) + getModelIndex();
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
    public com.google.protobuf.Parser<LogPullResponse> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public org.bupt.cad.fedraft.rpc.message.LogPullResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code fedraft.LogPullResponse}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:fedraft.LogPullResponse)
            org.bupt.cad.fedraft.rpc.message.LogPullResponseOrBuilder {
        private com.google.protobuf.ByteString modelChunk_ = com.google.protobuf.ByteString.EMPTY;
        private int modelIndex_;

        // Construct using org.bupt.cad.fedraft.rpc.message.LogPullResponse.newBuilder()
        private Builder() {

        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);

        }

        public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogPullResponse_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogPullResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.bupt.cad.fedraft.rpc.message.LogPullResponse.class, org.bupt.cad.fedraft.rpc.message.LogPullResponse.Builder.class);
        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            modelChunk_ = com.google.protobuf.ByteString.EMPTY;

            modelIndex_ = 0;

            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return org.bupt.cad.fedraft.rpc.message.LogMessage.internal_static_fedraft_LogPullResponse_descriptor;
        }

        @java.lang.Override
        public org.bupt.cad.fedraft.rpc.message.LogPullResponse getDefaultInstanceForType() {
            return org.bupt.cad.fedraft.rpc.message.LogPullResponse.getDefaultInstance();
        }

        @java.lang.Override
        public org.bupt.cad.fedraft.rpc.message.LogPullResponse build() {
            org.bupt.cad.fedraft.rpc.message.LogPullResponse result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public org.bupt.cad.fedraft.rpc.message.LogPullResponse buildPartial() {
            org.bupt.cad.fedraft.rpc.message.LogPullResponse result = new org.bupt.cad.fedraft.rpc.message.LogPullResponse(this);
            result.modelChunk_ = modelChunk_;
            result.modelIndex_ = modelIndex_;
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
            if (other instanceof org.bupt.cad.fedraft.rpc.message.LogPullResponse) {
                return mergeFrom((org.bupt.cad.fedraft.rpc.message.LogPullResponse) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(org.bupt.cad.fedraft.rpc.message.LogPullResponse other) {
            if (other == org.bupt.cad.fedraft.rpc.message.LogPullResponse.getDefaultInstance()) return this;
            if (other.getModelChunk() != com.google.protobuf.ByteString.EMPTY) {
                setModelChunk(other.getModelChunk());
            }
            if (other.getModelIndex() != 0) {
                setModelIndex(other.getModelIndex());
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
                        case 10: {
                            modelChunk_ = input.readBytes();

                            break;
                        } // case 10
                        case 16: {
                            modelIndex_ = input.readUInt32();

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
         * <pre>
         * 模型的序列化块
         * </pre>
         *
         * <code>bytes model_chunk = 1;</code>
         *
         * @return The modelChunk.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString getModelChunk() {
            return modelChunk_;
        }

        /**
         * <pre>
         * 模型的序列化块
         * </pre>
         *
         * <code>bytes model_chunk = 1;</code>
         * @param value The modelChunk to set.
         * @return This builder for chaining.
     */
    public Builder setModelChunk(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }

      modelChunk_ = value;
      onChanged();
      return this;
    }

    /**
     * <pre>
     * 模型的序列化块
     * </pre>
     *
     * <code>bytes model_chunk = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearModelChunk() {

      modelChunk_ = getDefaultInstance().getModelChunk();
      onChanged();
      return this;
    }
    /**
     * <code>uint32 model_index = 2;</code>
     * @return The modelIndex.
     */
    @java.lang.Override
    public int getModelIndex() {
        return modelIndex_;
    }

        /**
         * <code>uint32 model_index = 2;</code>
         *
         * @param value The modelIndex to set.
         * @return This builder for chaining.
         */
        public Builder setModelIndex(int value) {

            modelIndex_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>uint32 model_index = 2;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearModelIndex() {

            modelIndex_ = 0;
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


    // @@protoc_insertion_point(builder_scope:fedraft.LogPullResponse)
  }

}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jobmanager_message.proto

package org.bupt.fedraft.rpc.jobmanager.message;

/**
 * Protobuf type {@code fedraft.JobVoteResponse}
 */
public final class JobVoteResponse extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.JobVoteResponse)
        JobVoteResponseOrBuilder {
    public static final int TERM_FIELD_NUMBER = 1;
    public static final int VOTEGRANTED_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:fedraft.JobVoteResponse)
    private static final org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<JobVoteResponse>
            PARSER = new com.google.protobuf.AbstractParser<JobVoteResponse>() {
        @java.lang.Override
        public JobVoteResponse parsePartialFrom(
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
        DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse();
    }

    private int term_;
    private boolean voteGranted_;
    private byte memoizedIsInitialized = -1;

    // Use JobVoteResponse.newBuilder() to construct.
    private JobVoteResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private JobVoteResponse() {
    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobVoteResponse_descriptor;
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<JobVoteResponse> parser() {
        return PARSER;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new JobVoteResponse();
    }

    @java.lang.Override
    public com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobVoteResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.class, org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.Builder.class);
    }

    /**
     * <code>int32 term = 1;</code>
     *
     * @return The term.
     */
    @java.lang.Override
    public int getTerm() {
        return term_;
    }

    /**
     * <pre>
     * 是否投票
     * </pre>
     *
     * <code>bool voteGranted = 2;</code>
     *
     * @return The voteGranted.
     */
    @java.lang.Override
    public boolean getVoteGranted() {
        return voteGranted_;
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

    public static Builder newBuilder(org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (term_ != 0) {
            output.writeInt32(1, term_);
        }
        if (voteGranted_) {
            output.writeBool(2, voteGranted_);
        }
        getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (term_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeInt32Size(1, term_);
        }
        if (voteGranted_) {
            size += com.google.protobuf.CodedOutputStream
                    .computeBoolSize(2, voteGranted_);
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
      if (!(obj instanceof org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse)) {
          return super.equals(obj);
      }
      org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse other = (org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse) obj;

      if (getTerm()
              != other.getTerm()) return false;
      if (getVoteGranted()
              != other.getVoteGranted()) return false;
      return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public int hashCode() {
      if (memoizedHashCode != 0) {
          return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TERM_FIELD_NUMBER;
      hash = (53 * hash) + getTerm();
      hash = (37 * hash) + VOTEGRANTED_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
              getVoteGranted());
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
    public com.google.protobuf.Parser<JobVoteResponse> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code fedraft.JobVoteResponse}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:fedraft.JobVoteResponse)
            org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponseOrBuilder {
        private int term_;
        private boolean voteGranted_;

        // Construct using org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.newBuilder()
        private Builder() {

        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);

        }

        public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobVoteResponse_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobVoteResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.class, org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.Builder.class);
        }

        @java.lang.Override
        public org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse getDefaultInstanceForType() {
            return org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.getDefaultInstance();
        }

        @java.lang.Override
        public org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse build() {
            org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            term_ = 0;

            voteGranted_ = false;

            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return org.bupt.fedraft.rpc.jobmanager.message.JobmanagerMessage.internal_static_fedraft_JobVoteResponse_descriptor;
        }

        @java.lang.Override
        public org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse buildPartial() {
            org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse result = new org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse(this);
            result.term_ = term_;
            result.voteGranted_ = voteGranted_;
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
        public boolean isInitialized() {
            return true;
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse) {
                return mergeFrom((org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse other) {
            if (other == org.bupt.fedraft.rpc.jobmanager.message.JobVoteResponse.getDefaultInstance()) return this;
            if (other.getTerm() != 0) {
                setTerm(other.getTerm());
            }
            if (other.getVoteGranted()) {
                setVoteGranted(other.getVoteGranted());
            }
            this.mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
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
                            term_ = input.readInt32();

                            break;
                        } // case 8
                        case 16: {
                            voteGranted_ = input.readBool();

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
         * <code>int32 term = 1;</code>
         *
         * @return The term.
         */
        @java.lang.Override
        public int getTerm() {
            return term_;
        }

        /**
         * <code>int32 term = 1;</code>
         *
         * @param value The term to set.
         * @return This builder for chaining.
         */
        public Builder setTerm(int value) {

            term_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>int32 term = 1;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearTerm() {

            term_ = 0;
            onChanged();
            return this;
        }

        /**
         * <pre>
         * 是否投票
         * </pre>
         *
         * <code>bool voteGranted = 2;</code>
         *
         * @return The voteGranted.
         */
        @java.lang.Override
        public boolean getVoteGranted() {
            return voteGranted_;
        }

        /**
         * <pre>
         * 是否投票
         * </pre>
         *
         * <code>bool voteGranted = 2;</code>
         *
         * @param value The voteGranted to set.
         * @return This builder for chaining.
         */
        public Builder setVoteGranted(boolean value) {

            voteGranted_ = value;
            onChanged();
            return this;
        }

        /**
         * <pre>
         * 是否投票
         * </pre>
         *
         * <code>bool voteGranted = 2;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearVoteGranted() {

            voteGranted_ = false;
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


        // @@protoc_insertion_point(builder_scope:fedraft.JobVoteResponse)
  }

}


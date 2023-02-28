// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager_message.proto

package org.bupt.fedraft.rpc.manager.message;

/**
 * Protobuf type {@code fedraft.CodeFile}
 */
public final class CodeFile extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:fedraft.CodeFile)
        CodeFileOrBuilder {
  public static final int FILENAME_FIELD_NUMBER = 1;
  public static final int CODE_FIELD_NUMBER = 2;
  private static final long serialVersionUID = 0L;
  // @@protoc_insertion_point(class_scope:fedraft.CodeFile)
  private static final org.bupt.fedraft.rpc.manager.message.CodeFile DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<CodeFile>
          PARSER = new com.google.protobuf.AbstractParser<CodeFile>() {
    @java.lang.Override
    public CodeFile parsePartialFrom(
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
    DEFAULT_INSTANCE = new org.bupt.fedraft.rpc.manager.message.CodeFile();
  }

  private volatile java.lang.Object fileName_;
  private volatile java.lang.Object code_;
  private byte memoizedIsInitialized = -1;

  // Use CodeFile.newBuilder() to construct.
  private CodeFile(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private CodeFile() {
    fileName_ = "";
    code_ = "";
  }

  public static com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_CodeFile_descriptor;
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(org.bupt.fedraft.rpc.manager.message.CodeFile prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static org.bupt.fedraft.rpc.manager.message.CodeFile getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<CodeFile> parser() {
    return PARSER;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
          UnusedPrivateParameter unused) {
    return new CodeFile();
  }

  @java.lang.Override
  public com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
  internalGetFieldAccessorTable() {
    return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_CodeFile_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    org.bupt.fedraft.rpc.manager.message.CodeFile.class, org.bupt.fedraft.rpc.manager.message.CodeFile.Builder.class);
  }

  /**
   * <code>string fileName = 1;</code>
   *
   * @return The fileName.
   */
  @java.lang.Override
  public java.lang.String getFileName() {
    java.lang.Object ref = fileName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fileName_ = s;
      return s;
    }
  }

  /**
   * <code>string fileName = 1;</code>
   *
   * @return The bytes for fileName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
  getFileNameBytes() {
    java.lang.Object ref = fileName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                      (java.lang.String) ref);
      fileName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  /**
   * <code>string code = 2;</code>
   *
   * @return The code.
   */
  @java.lang.Override
  public java.lang.String getCode() {
    java.lang.Object ref = code_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      code_ = s;
      return s;
    }
  }

  /**
   * <code>string code = 2;</code>
   *
   * @return The bytes for code.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
  getCodeBytes() {
    java.lang.Object ref = code_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                      (java.lang.String) ref);
      code_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fileName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, fileName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(code_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, code_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fileName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, fileName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(code_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, code_);
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
    if (!(obj instanceof org.bupt.fedraft.rpc.manager.message.CodeFile)) {
      return super.equals(obj);
    }
    org.bupt.fedraft.rpc.manager.message.CodeFile other = (org.bupt.fedraft.rpc.manager.message.CodeFile) obj;

    if (!getFileName()
            .equals(other.getFileName())) return false;
    if (!getCode()
            .equals(other.getCode())) return false;
    return getUnknownFields().equals(other.getUnknownFields());
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FILENAME_FIELD_NUMBER;
    hash = (53 * hash) + getFileName().hashCode();
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode().hashCode();
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
  public com.google.protobuf.Parser<CodeFile> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bupt.fedraft.rpc.manager.message.CodeFile getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Protobuf type {@code fedraft.CodeFile}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:fedraft.CodeFile)
          org.bupt.fedraft.rpc.manager.message.CodeFileOrBuilder {
    private java.lang.Object fileName_ = "";
    private java.lang.Object code_ = "";

    // Construct using org.bupt.fedraft.rpc.manager.message.CodeFile.newBuilder()
    private Builder() {

    }

    private Builder(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }

    public static com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_CodeFile_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_CodeFile_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      org.bupt.fedraft.rpc.manager.message.CodeFile.class, org.bupt.fedraft.rpc.manager.message.CodeFile.Builder.class);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      fileName_ = "";

      code_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
    getDescriptorForType() {
      return org.bupt.fedraft.rpc.manager.message.ManagerMessage.internal_static_fedraft_CodeFile_descriptor;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.CodeFile getDefaultInstanceForType() {
      return org.bupt.fedraft.rpc.manager.message.CodeFile.getDefaultInstance();
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.CodeFile build() {
      org.bupt.fedraft.rpc.manager.message.CodeFile result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bupt.fedraft.rpc.manager.message.CodeFile buildPartial() {
      org.bupt.fedraft.rpc.manager.message.CodeFile result = new org.bupt.fedraft.rpc.manager.message.CodeFile(this);
      result.fileName_ = fileName_;
      result.code_ = code_;
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
      if (other instanceof org.bupt.fedraft.rpc.manager.message.CodeFile) {
        return mergeFrom((org.bupt.fedraft.rpc.manager.message.CodeFile) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bupt.fedraft.rpc.manager.message.CodeFile other) {
      if (other == org.bupt.fedraft.rpc.manager.message.CodeFile.getDefaultInstance()) return this;
      if (!other.getFileName().isEmpty()) {
        fileName_ = other.fileName_;
        onChanged();
      }
      if (!other.getCode().isEmpty()) {
        code_ = other.code_;
        onChanged();
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
              fileName_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 18: {
              code_ = input.readStringRequireUtf8();

              break;
            } // case 18
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
     * <code>string fileName = 1;</code>
     * @return The fileName.
     */
    public java.lang.String getFileName() {
      java.lang.Object ref = fileName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fileName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }

    /**
     * <code>string fileName = 1;</code>
     *
     * @param value The fileName to set.
     * @return This builder for chaining.
     */
    public Builder setFileName(
            java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      fileName_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string fileName = 1;</code>
     *
     * @return The bytes for fileName.
     */
    public com.google.protobuf.ByteString
    getFileNameBytes() {
      java.lang.Object ref = fileName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        fileName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     * <code>string fileName = 1;</code>
     *
     * @param value The bytes for fileName to set.
     * @return This builder for chaining.
     */
    public Builder setFileNameBytes(
            com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      fileName_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string fileName = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFileName() {

      fileName_ = getDefaultInstance().getFileName();
      onChanged();
      return this;
    }

    /**
     * <code>string code = 2;</code>
     *
     * @return The code.
     */
    public java.lang.String getCode() {
      java.lang.Object ref = code_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        code_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }

    /**
     * <code>string code = 2;</code>
     *
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(
            java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      code_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string code = 2;</code>
     *
     * @return The bytes for code.
     */
    public com.google.protobuf.ByteString
    getCodeBytes() {
      java.lang.Object ref = code_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        code_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     * <code>string code = 2;</code>
     *
     * @param value The bytes for code to set.
     * @return This builder for chaining.
     */
    public Builder setCodeBytes(
            com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      code_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string code = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCode() {

      code_ = getDefaultInstance().getCode();
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


    // @@protoc_insertion_point(builder_scope:fedraft.CodeFile)
  }

}


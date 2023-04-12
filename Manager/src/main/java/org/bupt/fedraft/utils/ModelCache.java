package org.bupt.fedraft.utils;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

/**
 * 用于缓存Model
 *
 * @author yzzer
 */
public class ModelCache extends ArrayList<ByteString> {


    private StreamObserver<ByteString> observer;

    public ModelCache(int size) {
        super(size);
    }

    public void setObserver(StreamObserver<ByteString> observer) {
        this.observer = observer;
    }

    @Override
    public boolean add(ByteString chunk) {
        if (observer != null) {
            observer.onNext(chunk);
        }
        return super.add(chunk);
    }
}

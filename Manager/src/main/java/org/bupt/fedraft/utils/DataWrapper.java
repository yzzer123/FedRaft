package org.bupt.fedraft.utils;

/**
 * @author yzzer
 */
public class DataWrapper <T> {


    private T data;

    public T get() {
        return data;
    }

    public void set(T data) {
        this.data = data;
    }

    public DataWrapper(T data){
        set(data);
    }

    public DataWrapper(){

    }


}

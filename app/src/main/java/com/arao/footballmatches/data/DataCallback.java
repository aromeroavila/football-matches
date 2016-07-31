package com.arao.footballmatches.data;

public interface DataCallback<T> {

    void onSuccess(T result);

    void onError();

}

package com.arao.footballmatches.data.repository;

public interface DataCallback<T> {

    void onSuccess(T result);

    void onError();

}

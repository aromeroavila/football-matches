package com.arao.footballmatches.data.net;

import com.arao.footballmatches.data.DataCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class RetrofitCallbackConverter<T> implements Callback<T> {

    private final DataCallback<T> dataCallback;

    RetrofitCallbackConverter(DataCallback<T> dataCallback) {
        this.dataCallback = dataCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            dataCallback.onSuccess(response.body());
        } else {
            dataCallback.onError();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        dataCallback.onError();
    }
}

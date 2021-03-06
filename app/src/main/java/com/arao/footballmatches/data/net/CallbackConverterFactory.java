package com.arao.footballmatches.data.net;

import com.arao.footballmatches.data.DataCallback;

public class CallbackConverterFactory {

    <T> RetrofitCallbackConverter<T> getRetrofitCallbackConverter(DataCallback<T> dataCallback) {
        return new RetrofitCallbackConverter<>(dataCallback);
    }

}

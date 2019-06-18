package com.webee.challange.data.remote;

import androidx.annotation.NonNull;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 *
 * This okhttp interceptor is responsible for adding the common query parameters and headers
 *
 **/
public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl url = originalHttpUrl.newBuilder().build();

        Request request = originalRequest.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
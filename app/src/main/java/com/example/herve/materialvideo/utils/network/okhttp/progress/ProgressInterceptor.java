package com.example.herve.materialvideo.utils.network.okhttp.progress;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by lidongyang on 2016/5/11.
 */
public class ProgressInterceptor implements Interceptor {

    protected final ProgressListener progressListener;

    public ProgressInterceptor(ProgressListener progressListener) {
        this.progressListener = progressListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(new ProgressResponseBody(response.body(), progressListener)).build();
    }
}

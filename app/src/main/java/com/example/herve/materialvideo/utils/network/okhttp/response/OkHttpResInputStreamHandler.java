package com.example.herve.materialvideo.utils.network.okhttp.response;

import java.io.InputStream;

import okhttp3.Response;

/**
 * Created by ldy on 2015/12/30.
 */
public abstract class OkHttpResInputStreamHandler extends OkHttpCallback<InputStream> {

    @Override
    protected InputStream parseResponse(Response response) throws Throwable {
        return response.body().byteStream();
    }
}

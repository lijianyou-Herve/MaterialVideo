package com.example.herve.materialvideo.utils.network.okhttp.response;

import okhttp3.Response;

/**
 * Created by ldy on 2015/12/30.
 */
public abstract class OkHttpResResponseHandler extends OkHttpCallback<Response> {

    @Override
    protected Response parseResponse(Response response) throws Throwable {
        return response;
    }
}

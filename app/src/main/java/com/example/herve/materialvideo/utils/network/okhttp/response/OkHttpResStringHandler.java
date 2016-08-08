package com.example.herve.materialvideo.utils.network.okhttp.response;

import okhttp3.Response;

/**
 * Created by ldy on 2015/12/30.
 */
public abstract class OkHttpResStringHandler extends OkHttpCallback<String> {

    @Override
    protected String parseResponse(Response response) throws Throwable {
        return responseToString(response);
    }
}

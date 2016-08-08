package com.example.herve.materialvideo.utils.network.okhttp.response;

import com.alibaba.fastjson.JSON;

import okhttp3.Response;

/**
 * Created by ldy on 2015/12/30.
 */
public abstract class OkHttpResBeanHandler<T> extends OkHttpCallback<T> {

    @Override
    protected T parseResponse(Response response) throws Throwable {
        return JSON.parseObject(responseToString(response), getGenericType());
    }
}

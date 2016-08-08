package com.example.herve.materialvideo.utils.network.okhttp.response;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Response;

/**
 * Created by lidongyang on 2016/5/17.
 */
public abstract class OkHttpResBitmapHandler extends OkHttpCallback<Bitmap> {

    @Override
    protected Bitmap parseResponse(Response response) throws Throwable {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }
}

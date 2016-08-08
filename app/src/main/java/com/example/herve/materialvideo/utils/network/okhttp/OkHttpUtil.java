package com.example.herve.materialvideo.utils.network.okhttp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.herve.materialvideo.utils.network.okhttp.cookie.PersistentCookieJar;
import com.example.herve.materialvideo.utils.network.okhttp.progress.ProgressRequestBody;
import com.example.herve.materialvideo.utils.network.okhttp.response.OkHttpCallback;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ldy on 2015/12/29.
 */
public class OkHttpUtil {

    private static final String TAG = OkHttpUtil.class.getSimpleName();
    public static final int DEFAULT_CONNECT_TIMEOUT = 30 * 1000;
    public static final int DEFAULT_WRITE_TIMEOUT = 60 * 1000;
    public static final int DEFAULT_READ_TIMEOUT = 60 * 1000;

    private static OkHttpClient mOkHttpClient = null;
    private static Handler mOkHandler = null;

    public static void init(Context context) {
        mOkHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                .cookieJar(new PersistentCookieJar(context.getApplicationContext()))
                .build();
    }

    public static <T> void get(String url, OkHttpCallback<T> okHttpCallback) {
        get(url, null, okHttpCallback);
    }

    public static <T> void get(String url, OkRequestParams params, OkHttpCallback<T> okHttpCallback) {
        get(url, params, null, okHttpCallback);
    }

    public static <T> void get(String url, Object tag, OkHttpCallback<T> okHttpCallback) {
        get(url, null, tag, okHttpCallback);
    }

    public static <T> void get(String url, OkRequestParams params, Object tag, OkHttpCallback<T> okHttpCallback) {
        OkHttpLog.d(TAG, getFinalUrl(url, params));

        Call call = null;
        Callback callback = getCallBack(okHttpCallback);
        try {
            RequestBody requestBody = getRequestBody(params);
            Headers headers = getRequestHeaders(params);
            Request request = getRequest(getFinalUrl(url, params), requestBody, headers, tag);

            call = mOkHttpClient.newCall(request);
            call.enqueue(callback);
        } catch (Throwable e) {
            e.printStackTrace();
            callback.onFailure(call, new IOException("get", e));
        }
    }

    public static <T> void post(String url, OkHttpCallback<T> okHttpCallback) {
        post(url, null, okHttpCallback);
    }

    public static <T> void post(String url, OkRequestParams params, OkHttpCallback<T> okHttpCallback) {
        post(url, params, null, okHttpCallback);
    }

    public static <T> void post(String url, OkRequestParams params, Object tag, OkHttpCallback<T> okHttpCallback) {
        post(url, params, tag, false, okHttpCallback);
    }

    public static <T> void post(String url, OkRequestParams params, Object tag, boolean isProgress, OkHttpCallback<T> okHttpCallback) {
        OkHttpLog.d(TAG, getFinalUrl(url, params));

        Call call = null;
        Callback callback = getCallBack(okHttpCallback);
        try {
            RequestBody requestBody = getRequestBody(params, isProgress, okHttpCallback);
            Headers headers = getRequestHeaders(params);
            Request request = getRequest(url, requestBody, headers, tag);

            call = mOkHttpClient.newCall(request);
            call.enqueue(callback);
        } catch (Throwable e) {
            e.printStackTrace();
            callback.onFailure(call, new IOException("post", e));
        }
    }

    public static <T> void syncPost(String url, OkHttpCallback<T> okHttpCallback) {
        syncPost(url, null, okHttpCallback);
    }

    public static <T> void syncPost(String url, OkRequestParams params, OkHttpCallback<T> okHttpCallback) {
        syncPost(url, params, null, okHttpCallback);
    }

    public static <T> void syncPost(String url, OkRequestParams params, Object tag, OkHttpCallback<T> okHttpCallback) {
        syncPost(url, params, tag, false, okHttpCallback);
    }

    public static <T> void syncPost(String url, OkRequestParams params, Object tag, boolean isProgress, OkHttpCallback<T> okHttpCallback) {
        OkHttpLog.d(TAG, getFinalUrl(url, params));

        Call call = null;
        Callback callback = getCallBack(okHttpCallback);
        try {
            RequestBody requestBody = getRequestBody(params, isProgress, okHttpCallback);
            Headers headers = getRequestHeaders(params);
            Request request = getRequest(url, requestBody, headers, tag);

            call = mOkHttpClient.newCall(request);
            Response response = call.execute();
            if (response != null) {
                callback.onResponse(call, response);
            } else {
                callback.onFailure(call, new IOException("syncPost: response == null"));
            }
        } catch (Throwable e) {
            e.printStackTrace();
            callback.onFailure(call, new IOException("syncPost", e));
        }
    }

    public static void cancelTag(Object tag) {
        try {
            for (Call call : mOkHttpClient.dispatcher().queuedCalls()) {
                if (tag.equals(call.request().tag())) {
                    call.cancel();
                }
            }
            for (Call call : mOkHttpClient.dispatcher().runningCalls()) {
                if (tag.equals(call.request().tag())) {
                    call.cancel();
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static <T> Callback getCallBack(OkHttpCallback<T> okHttpCallBack) {
        if (okHttpCallBack == null) {
            return OkHttpCallback.DEFAULT_CALLBACK;
        } else {
            okHttpCallBack.setHandler(getOkHandler());
            return okHttpCallBack;
        }
    }

    public static Request getRequest(String url, RequestBody requestBody, Headers headers, Object tag) {
        Request.Builder builder = new Request.Builder();
        if (requestBody != null) {
            builder.post(requestBody);
        }
        if (headers != null) {
            builder.headers(headers);
        }
        if (tag != null) {
            builder.tag(tag);
        }
        builder.url(url);
        return builder.build();
    }

    public static String getFinalUrl(String url, OkRequestParams params) {
        if (params != null) {
            String paramString = params.getParamString().trim();
            if (!paramString.equals("") && !paramString.equals("?")) {
                url += url.contains("?") ? "&" : "?";
                url += paramString;
            }
        }
        return url;
    }

    private static Headers getRequestHeaders(OkRequestParams params) {
        return params == null ? null : params.getRequestHeaders();
    }

    private static RequestBody getRequestBody(OkRequestParams params) {
        return params == null ? null : params.getRequestBody();
    }

    private static <T> RequestBody getRequestBody(OkRequestParams params, boolean isProgress, OkHttpCallback<T> okHttpCallback) {
        RequestBody requestBody = getRequestBody(params);
        if (requestBody != null && isProgress && okHttpCallback != null) {
            requestBody = new ProgressRequestBody(requestBody, okHttpCallback);
        }
        return requestBody;
    }

    private static Handler getOkHandler() {
        if (mOkHandler == null) {
            mOkHandler = new Handler(Looper.getMainLooper());
        }
        return mOkHandler;
    }
}

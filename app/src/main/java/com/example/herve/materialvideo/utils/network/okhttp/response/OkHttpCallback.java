package com.example.herve.materialvideo.utils.network.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.example.herve.materialvideo.utils.network.okhttp.progress.ProgressListener;

import org.json.JSONTokener;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by lidongyang on 2016/5/3.
 */
public abstract class OkHttpCallback<T> implements Callback, ProgressListener {
    /** 网络错误 **/
    public static final int RESPONSE_ERROR_NET = 1;
    /** 服务器错误 **/
    public static final int RESPONSE_ERROR_SERVER = 2;
    /** 连接超时 **/
    public static final int RESPONSE_ERROR_TIMEOUT = 3;

    protected Handler mOkHandler = null;

    public abstract void onSuccess(int code, Headers headers, T response);

    public abstract void onFailure(int code, Headers headers, int error, Throwable t);

    public void onProgress(long curSize, long totalSize, float progress, boolean done) {}

    protected abstract T parseResponse(Response response) throws Throwable;

    protected final void onSuccess(Response response) throws Throwable {
        T responseObject = parseResponse(response);
        if (responseObject != null) {
            onSuccessRequest(response.code(), response.headers(), responseObject);
        } else {
            onFailureRequest(response.code(), response.headers(), RESPONSE_ERROR_SERVER, new Throwable("responseObject == null"));
        }
    }

    protected void onSuccessRequest(final int code, final Headers headers, final T response) {
        getOkHandler().post(new Runnable() {
            @Override
            public void run() {
                onSuccess(code, headers, response);
            }
        });
    }

    protected void onFailureRequest(final int code, final Headers headers, final int error, final Throwable t) {
        getOkHandler().post(new Runnable() {
            @Override
            public void run() {
                onFailure(code, headers, code == 504 ? RESPONSE_ERROR_TIMEOUT : error, t);
            }
        });
    }

    @Override
    public void update(final long bytes, final long contentLength, final boolean done) {
        getOkHandler().post(new Runnable() {
            @Override
            public void run() {
                onProgress(bytes, contentLength, bytes * 1.0f / contentLength, done);
            }
        });
    }

    @Override
    public final void onResponse(Call call, Response response) throws IOException {
        if (response != null) {
            try {
                if (response.isSuccessful()) {
                    onSuccess(response);
                } else {
                    onFailureRequest(response.code(), response.headers(), RESPONSE_ERROR_NET, new Throwable("!response.isSuccessful()"));
                }
                close(response.body());
            } catch (Throwable e) {
                onFailureRequest(response.code(), response.headers(), RESPONSE_ERROR_NET, e);
                close(response.body());
            }
        } else {
            onFailureRequest(0, null, RESPONSE_ERROR_NET, new Throwable("response == null"));
        }
    }

    @Override
    public final void onFailure(Call call, IOException e) {
        onFailureRequest(0, null, RESPONSE_ERROR_NET, e);
    }

    protected final void close(ResponseBody body) {
        if (body == null) return;
        try {
            body.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    protected final T responseToJson(Response response) throws Throwable {
        String responseStr = responseToString(response).trim();
        if (responseStr.startsWith("{") || responseStr.startsWith("[")) {
            return (T) new JSONTokener(responseStr).nextValue();
        }
        return null;
    }

    protected final String responseToString(Response response) throws Throwable {
        String responseStr = response.body().string().trim();
        if (responseStr.startsWith("\ufeff")) {
            responseStr = responseStr.substring(1);
        }
        return responseStr;
    }

    /**
     * 返回泛型 .class
     * @return
     */
    protected final Type getGenericType() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) superclass).getActualTypeArguments();
            if (params.length > 0)
                return params[0];
        }
        return Object.class;
    }

    public final void setHandler(Handler okHandler) {
        this.mOkHandler = okHandler;
    }

    public final Handler getOkHandler() {
        return mOkHandler == null ? new Handler(Looper.getMainLooper()) : mOkHandler;
    }

    public static final Callback DEFAULT_CALLBACK = new Callback() {

        @Override
        public void onFailure(Call call, IOException e) {
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
        }
    };
}

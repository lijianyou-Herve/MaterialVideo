package com.example.herve.materialvideo.utils.network.okhttp.progress;

/**
 * Created by lidongyang on 2016/5/11.
 */
public interface ProgressListener {
    /**
     * 上传下载进度检测
     *
     * @param bytes
     * @param contentLength
     * @param done
     */
    void update(long bytes, long contentLength, boolean done);
}

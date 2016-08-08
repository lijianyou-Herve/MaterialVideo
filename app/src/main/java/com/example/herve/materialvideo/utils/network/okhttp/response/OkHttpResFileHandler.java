package com.example.herve.materialvideo.utils.network.okhttp.response;

import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Response;

/**
 * Created by lidongyang on 2016/5/17.
 */
public abstract class OkHttpResFileHandler extends OkHttpCallback<File> {

    private final String dirPath;
    private final String fileName;
    private long lastRefreshTime;

    public OkHttpResFileHandler(String dirPath, String fileName) {
        this.dirPath = dirPath;
        this.fileName = fileName;
        this.lastRefreshTime = System.currentTimeMillis();
    }

    @Override
    protected File parseResponse(Response response) throws Throwable {

        if (TextUtils.isEmpty(dirPath) || TextUtils.isEmpty(fileName))
            return null;

        if (!makeFolders())
            return null;

        File file = new File(dirPath, fileName);

        if (file.exists())
            deleteFile(file);

        InputStream inputStream = null;
        byte[] buf = new byte[2048];
        FileOutputStream fos = null;
        try {
            inputStream = response.body().byteStream();
            final long totalSize = response.body().contentLength();
            long curSize = 0;
            int len;
            fos = new FileOutputStream(file, false);
            while ((len = inputStream.read(buf)) != -1) {
                curSize += len;
                fos.write(buf, 0, len);
                updateProgress(curSize, totalSize, curSize == totalSize);
            }
            fos.flush();
            updateProgress(curSize, totalSize, curSize == totalSize);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void updateProgress(long bytes, long contentLength, boolean done) {
        long curTime = System.currentTimeMillis();
        if (curTime - lastRefreshTime >= 1000 || done) {
            update(bytes, contentLength, done);
            lastRefreshTime = System.currentTimeMillis();
        }
    }

    private boolean makeFolders() {
        File f = new File(dirPath);
        return (f.exists() && f.isDirectory()) || f.mkdirs();
    }

    private boolean deleteFile(File file) {
        return file.delete();
    }
}

package com.example.herve.materialvideo.application;

import android.app.Application;
import android.content.Context;

import com.okhttplib.OkHttpUtil;
import com.okhttplib.annotation.CacheLevel;
import com.okhttplib.annotation.CacheType;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Herve on 2016/7/30.
 */
public class AppLication extends Application {

    private RefWatcher refWatcher;
    //    public static String[] urls = new String[]{
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240001_1/encoder/1/playlist.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240002_1/encoder/1/playlist.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240245_1/encoder/1/playlist.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240005_1/encoder/1/playlist.m3u8",
//            "http://122.227.101.159:80/livehls1-cnc.wasu.cn/hd_cctv5/z.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240128_1/encoder/1/playlist.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240247_1/encoder/1/playlist.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240009_1/encoder/1/playlist.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240249_1/encoder/1/playlist.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240014_1/encoder/1/playlist.m3u8",
//            "http://106.36.45.36/live.aishang.ctlcdn.com/00000110240015_1/encoder/1/playlist.m3u8"
//
//    };
    public static String[] urls = new String[]{
            "http://live.gslb.letv.com/gslb?stream_id=lb_hkmovie_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1",
            "http://live.gslb.letv.com/gslb?stream_id=lb_ent_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1",
            "http://live.gslb.letv.com/gslb?stream_id=lb_music_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1",
            "http://live.gslb.letv.com/gslb?tag=live&stream_id=lb_dzdy_720p&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=C1S&expect=1",
            "http://live.gslb.letv.com/gslb?tag=live&stream_id=lb_movie_720p&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=C1S&expect=1",
            "http://live.gslb.letv.com/gslb?tag=live&stream_id=lb_zxc_720p&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=C1S&expect=1",
            "http://live.gslb.letv.com/gslb?tag=live&stream_id=lb_cl_720p&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=C1S&expect=1",
            "http://live.gslb.letv.com/gslb?tag=live&stream_id=lb_comedy_720p&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=C1S&expect=1",
            "http://live.gslb.letv.com/gslb?tag=live&stream_id=lb_erge_720p&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=C1S&expect=1",
            "http://live.gslb.letv.com/gslb?tag=live&stream_id=lb_livemusic_720p&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=C1S&expect=1",
            "ed2k://|file|FC674B387ED82C76CE619F36B2AD4CF7.mp4|2526378787|FC674B387ED82C76CE619F36B2AD4CF7|h=RB3YAZ7F4PU4NC6GWJ4LQGZDP27AY7C5|/"
    };

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        refWatcher = LeakCanary.install(this);

        OkHttpUtil.init(this)
                .setConnectTimeout(30)//连接超时时间
                .setWriteTimeout(30)//写超时时间
                .setReadTimeout(30)//读超时时间
                .setMaxCacheSize(10 * 1024 * 1024)//缓存空间大小
                .setCacheLevel(CacheLevel.FIRST_LEVEL)//缓存等级
                .setCacheType(CacheType.NETWORK_THEN_CACHE)//缓存类型
                .setShowHttpLog(true)//显示请求日志
                .setShowLifecycleLog(true)//显示Activity销毁日志
                .setRetryOnConnectionFailure(false)//失败后不自动重连
                .setDownloadFileDir("")//文件下载保存目录
                .build();
    }

    public static RefWatcher getRefWatcher(Context context) {
        AppLication application = (AppLication) context.getApplicationContext();
        return application.refWatcher;
    }

}

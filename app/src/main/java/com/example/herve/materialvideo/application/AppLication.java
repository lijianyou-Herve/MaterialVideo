package com.example.herve.materialvideo.application;

import android.app.Application;
import android.content.Context;

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

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        AppLication application = (AppLication) context.getApplicationContext();
        return application.refWatcher;
    }

}

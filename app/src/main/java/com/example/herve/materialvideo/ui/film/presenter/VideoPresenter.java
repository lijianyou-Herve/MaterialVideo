package com.example.herve.materialvideo.ui.film.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herve on 2016/8/7.
 */
public class VideoPresenter implements VideoContract.Presenter {


    private VideoContract.PresenterView presenterView;

    private Context mContext;
    private String dataUrl;
    private DataBean dataBean;
    private Handler mHandler;

    public VideoPresenter(VideoContract.PresenterView presenterView, Context mContext, String dataUrl) {
        this.presenterView = presenterView;
        this.mContext = mContext;
        this.dataUrl = dataUrl;
        mHandler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void initData() {

        presenterView.VideoViewVisibity(View.GONE);
        presenterView.ViewPagerVisibity(View.VISIBLE);
        dataBean = new DataBean();
        List<ItemBean> itemBeanlist = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ItemBean itemBean = new ItemBean("标题" + i, "下面的显示信息" + i);
            itemBeanlist.add(itemBean);
        }
        dataBean.setItemBean(itemBeanlist);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenterView.initData(dataBean);
                presenterView.VideoViewVisibity(View.VISIBLE);
                presenterView.ViewPagerVisibity(View.GONE);

            }
        }, 3000);


    }

    @Override
    public void videoStart() {

    }


    @Override
    public void videoStop() {

    }

    @Override
    public void videoPause() {

    }


    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

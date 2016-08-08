package com.example.herve.materialvideo.ui.home.fragments.filmFragment.presenter;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.herve.materialvideo.application.AppLication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herve on 2016/8/4.
 */
public class FilmFragmetPresenter implements FilmFragmentContract.Presentenr {

    private FilmFragmentContract.PresentenrView presentenrView;

    private Context mContext;

    public List<String> datas;

    Handler handler;

    public FilmFragmetPresenter(FilmFragmentContract.PresentenrView presentenrView, Context mContext) {
        this.presentenrView = presentenrView;
        this.mContext = mContext;
        initData();

    }

    @Override
    public void initData() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        datas = new ArrayList<>();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                datas.clear();

                for (int i = 0; i < 15; i++) {

                    datas.add("数据数量" + i);
                }

                presentenrView.setProgressBarVisiblity(View.INVISIBLE);

            }

        }, 3000);

    }

    @Override
    public void reFreshData() {
        presentenrView.setProgressBarVisiblity(View.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                datas.clear();

                for (int i = 0; i < AppLication.urls.length; i++) {

                    datas.add("数据数量" + i);
                }

                presentenrView.setProgressBarVisiblity(View.INVISIBLE);

            }

        }, 3000);

    }

    @Override
    public void onItemClick(View view, int position) {
        presentenrView.onItemClick(view, position);

    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

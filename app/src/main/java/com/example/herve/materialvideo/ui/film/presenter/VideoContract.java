package com.example.herve.materialvideo.ui.film.presenter;

import com.example.herve.materialvideo.base.BasePresenter;
import com.example.herve.materialvideo.base.BasePresenterView;

/**
 * Created by Herve on 2016/8/7.
 */
public interface VideoContract {

    public interface Presenter extends BasePresenter {
        void initData();

        void videoStart();

        void videoStop();

        void videoPause();


    }

    public interface PresenterView extends BasePresenterView<Presenter> {
        void initData(DataBean dataBean);

        void reFresh();

        void VideoViewVisibity(int visibity);

        void ViewPagerVisibity(int visibity);

    }
}

package com.example.herve.materialvideo.ui.home.fragments.filmFragment.presenter;

import android.view.View;

import com.example.herve.materialvideo.base.BasePresenter;
import com.example.herve.materialvideo.base.BasePresenterView;

/**
 * Created by Herve on 2016/8/4.
 */
public interface FilmFragmentContract {

    public interface Presentenr extends BasePresenter {
        void initData();

        void reFreshData();

        void onItemClick(View view, int position);

        void setProgressBarVisiblity(int visiblity);
    }

    public interface PresentenrView extends BasePresenterView<Presentenr> {

        void onItemClick(View view,int position);

        void setProgressBarVisiblity(int visiblity);
    }
}

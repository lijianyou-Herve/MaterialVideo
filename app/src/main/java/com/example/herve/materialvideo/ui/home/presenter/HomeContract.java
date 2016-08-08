package com.example.herve.materialvideo.ui.home.presenter;

import android.support.v4.app.Fragment;

import com.example.herve.materialvideo.base.BasePresenter;
import com.example.herve.materialvideo.base.BasePresenterView;

/**
 * Created by Herve on 2016/8/4.
 */
public interface HomeContract {

    public interface Presenter extends BasePresenter {
        void transitionFragments(Fragment fragment);
    }

    public interface PresenterView extends BasePresenterView<Presenter> {
        void reloadFragment(Fragment fragment);

    }
}

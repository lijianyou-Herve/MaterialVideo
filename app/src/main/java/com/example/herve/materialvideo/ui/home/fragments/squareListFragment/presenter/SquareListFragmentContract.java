package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.presenter;

import android.support.v4.app.Fragment;

import com.example.herve.materialvideo.base.BaseFragment;
import com.example.herve.materialvideo.base.BasePresenter;
import com.example.herve.materialvideo.base.BasePresenterView;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareListData;

import java.util.List;

/**
 * Created           :Herve on 2016/8/13.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/13
 * @ projectName     :MaterialVideo
 * @ version
 */
public interface SquareListFragmentContract {

    public interface Presenter extends BasePresenter {

        void initData();

        void reFresh();

        void changeTag(int positoin);


    }

    public interface PresenterView extends BasePresenterView<Presenter> {

        void initData(List<BaseFragment> fragmentList);

        void reFresh();

        void visibity(int visibity);


    }
}
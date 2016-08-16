package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments.bilibilifragment.presenter;

import com.example.herve.materialvideo.base.BasePresenter;
import com.example.herve.materialvideo.base.BasePresenterView;
import com.example.herve.materialvideo.data.bean.bilibili.PartitionsBean;
import com.example.herve.materialvideo.data.bean.bjxbean.BJXTabBean;
import com.example.herve.materialvideo.data.bean.bjxbean.SquareBannerBean;
import com.example.herve.materialvideo.data.bean.bjxbean.SquareTypeGroupBean;

import java.util.List;

/**
 * Created           :Herve on 2016/8/15.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/15
 * @ projectName     :MaterialVideo
 * @ version
 */
public interface BiliBiliContract {

    public interface Presenter extends BasePresenter {


    }

    public interface PresenterView extends BasePresenterView<Presenter> {

        void refreshBanner(SquareBannerBean bannerBeans);

        void refreshPartitions(List<SquareTypeGroupBean> squareTypeGroupBeens);

        void reFresh();

        void VideoViewVisibity(int visibity);

        void ViewPagerVisibity(int visibity);

    }
}
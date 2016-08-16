package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments.bilibilifragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.base.BaseFragment;
import com.example.herve.materialvideo.data.bean.bilibili.TestBannerBean;
import com.example.herve.materialvideo.data.bean.bilibili.PartitionsBean;
import com.example.herve.materialvideo.data.bean.bjxbean.SquareBannerBean;
import com.example.herve.materialvideo.data.bean.bjxbean.SquareTypeGroupBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.adapter.SquareDataAdapter;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments.bilibilifragment.presenter.BiliBiliContract;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments.bilibilifragment.presenter.BiliBiliPrsenter;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.BannerBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareFilmBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareListData;
import com.example.herve.materialvideo.widget.imageloader.ImageLoader;
import com.example.herve.materialvideo.widget.imageloader.ImageLoaderUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created           :Herve on 2016/8/13.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/13
 * @ projectName     :MaterialVideo
 * @ version
 */
public class BilibiliFragment extends BaseFragment implements BiliBiliContract.PresenterView {


    @BindView(R.id.square_recycle_view)
    RecyclerView squareRecycleView;
    @BindView(R.id.iv_banner)
    ImageView ivBanner;
    @BindView(R.id.ll_ban_root)
    RelativeLayout llBanRoot;

    private BiliBiliContract.Presenter presenter;
    private String TAG = getClass().getSimpleName();
    private ViewGroup rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView != null) {
            return rootView;
        }
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_square_type, null);
        ButterKnife.bind(this, rootView);


        initData();


        return rootView;
    }

    private void initData() {
        presenter = new BiliBiliPrsenter(this, mContext);

        presenter.start();
    }


    private void initdata(SquareTypeGroupBean squareTypeGroupBeens) {


        final SquareDataAdapter squareDataAdapter = new SquareDataAdapter(mContext, squareTypeGroupBeens.getSquareTypeContent());

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, 2);
        squareRecycleView.setLayoutManager(layoutManager);
        squareRecycleView.setItemAnimator(new DefaultItemAnimator());
        squareRecycleView.setAdapter(squareDataAdapter);


    }


    @Override
    public String getTittle() {
        return super.getTittle();
    }

    @Override
    public void setTittle(String tittle) {
        super.setTittle(tittle);
    }


    @Override
    public void refreshBanner(SquareBannerBean bannerBeans) {
        Log.i(TAG, "refreshBanner: " + bannerBeans.getSquareBannerContent().get(0).getBannerCoverUrl());
        //        ImageLoader imageLoader = new ImageLoader.Builder().resource(R.mipmap.film_cover).imgView(ivBanner).build();
        ImageLoader imageLoader = new ImageLoader.Builder().url(bannerBeans.getSquareBannerContent().get(1).getBannerCoverUrl()).imgView(ivBanner).build();
        ImageLoaderUtil.getInstance().loadImage(mContext, imageLoader);
//        Glide.with(mContext).load(bannerBeans.getSquareBannerContent().get(0).getBannerUrl()).into(ivBanner);

    }

    @Override
    public void refreshPartitions(List<SquareTypeGroupBean> squareTypeGroupBeens) {
        initdata(squareTypeGroupBeens.get(0));


    }


    @Override
    public void reFresh() {

    }

    @Override
    public void VideoViewVisibity(int visibity) {

    }

    @Override
    public void ViewPagerVisibity(int visibity) {

    }

    @Override
    public void setPresenter(BiliBiliContract.Presenter presenter) {

    }
}

package com.example.herve.materialvideo.ui.home.fragments.squareListFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.base.BaseFragment;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.adapter.SquareTypeFragmentAdapter;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments.SquareTypeFragment;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.BannerBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareFilmBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareListData;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.presenter.SquareListFragmentContract;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.presenter.SquareListFragmentPrsenter;
import com.example.herve.materialvideo.view.customviews.baseview.BaseProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Herve on 2016/6/19.
 */
public class SquareListFragment extends BaseFragment implements SquareListFragmentContract.PresenterView {

    @BindView(R.id.tab_square_list)
    TabLayout tabSquareList;
    @BindView(R.id.vp_square_list)
    ViewPager vpSquareList;
    @BindView(R.id.vp_progress)
    BaseProgressBar vpProgress;
    @BindView(R.id.square_swipeRefreshLayout)
    SwipeRefreshLayout squareSwipeRefreshLayout;


    private SquareListFragmentContract.Presenter presenter;

    private final String TAG = getClass().getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_film, null);

        ButterKnife.bind(this, view);

        initUi();
        initPresenter();
        initListener();

        return view;
    }

    private void initPresenter() {
        presenter = new SquareListFragmentPrsenter(this, mContext);
        presenter.initData();
    }

    private void initListener() {


        vpSquareList.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                squareSwipeRefreshLayout.setEnabled(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        squareSwipeRefreshLayout.setEnabled(false);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:

                        squareSwipeRefreshLayout.setEnabled(true);

                }

            }
        });

        squareSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.initData();
                squareSwipeRefreshLayout.setRefreshing(true);

            }
        });

    }


    private void initUi() {


    }


    @Override
    public void initData(List<BaseFragment> fragmentList) {

        SquareTypeFragmentAdapter squareTypeFragmentAdapter = new SquareTypeFragmentAdapter(mContext.getSupportFragmentManager(), fragmentList, null);
        vpSquareList.setAdapter(squareTypeFragmentAdapter);

        tabSquareList.setupWithViewPager(vpSquareList);
        vpSquareList.setCurrentItem(0);




    }

    @Override
    public void reFresh() {

    }

    @Override
    public void visibity(int visibity) {
        vpProgress.setVisibility(visibity);
        if (visibity == View.GONE) {
            squareSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void setPresenter(SquareListFragmentContract.Presenter presenter) {

    }
}

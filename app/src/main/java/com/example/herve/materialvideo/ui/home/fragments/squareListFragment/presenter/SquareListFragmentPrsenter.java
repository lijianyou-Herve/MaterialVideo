package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.herve.materialvideo.base.BaseFragment;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments.SquareTypeFragment;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments.bilibilifragment.BilibiliFragment;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.BannerBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareFilmBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareListData;

import java.util.ArrayList;
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
public class SquareListFragmentPrsenter implements SquareListFragmentContract.Presenter {


    private SquareListFragmentContract.PresenterView presenterView;

    private Context mContext;

    private Handler mHandler;


    private List<BaseFragment> fragList;

    public SquareListFragmentPrsenter(SquareListFragmentContract.PresenterView presenterView, Context mContext) {
        this.presenterView = presenterView;
        this.mContext = mContext;
        mHandler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void initData() {
        fragList = new ArrayList<>();
        presenterView.visibity(View.VISIBLE);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {


                BaseFragment squareTypeFragment;
                for (int i = 0; i < 4; i++) {

                    if (i == 0) {
                        squareTypeFragment = new BilibiliFragment();
                    } else {

                        squareTypeFragment = new SquareTypeFragment();
                    }

                    squareTypeFragment.setTittle("第" + i + "TAB");
                    fragList.add(squareTypeFragment);
                }
                presenterView.initData(fragList);
                presenterView.visibity(View.GONE);
            }

        }, 2000);


    }

    @Override
    public void reFresh() {

    }

    @Override
    public void changeTag(int positoin) {

    }
}
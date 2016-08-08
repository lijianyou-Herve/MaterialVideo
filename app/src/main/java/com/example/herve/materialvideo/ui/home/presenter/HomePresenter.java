package com.example.herve.materialvideo.ui.home.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.base.BaseActivity;

/**
 * Created by Herve on 2016/8/4.
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.PresenterView presenterView;

    private BaseActivity mContext;

    private Fragment showFragment;
    private FragmentTransaction fragmentTransaction;
    private String TAG = getClass().getSimpleName();

    public HomePresenter(HomeContract.PresenterView presenterView, BaseActivity mContext) {
        this.presenterView = presenterView;
        this.mContext = mContext;
    }

    @Override
    public void transitionFragments(Fragment fragment) {
        Log.i(TAG, "transitionFragments: fragment=" + fragment.getClass().getSimpleName());
        fragmentTransaction = mContext.getSupportFragmentManager().beginTransaction();

        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(R.id.frame_content, fragment);
        }

        if (showFragment != null && showFragment != fragment) {
            fragmentTransaction.hide(showFragment);
        }
        fragmentTransaction.commit();
        showFragment = fragment;

        presenterView.reloadFragment(fragment);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

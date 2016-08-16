package com.example.herve.materialvideo.ui.login.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

/**
 * Created           :Herve on 2016/8/10.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/10
 * @ projectName     :MaterialVideo
 * @ version
 */
public class LoginPresenter implements LoginContrart.presenter {


    private Context mContext;

    private LoginContrart.presenterView presenterView;

    private Handler mHandler;

    public LoginPresenter(Context mContext, LoginContrart.presenterView presenterView) {
        this.mContext = mContext;
        this.presenterView = presenterView;
        mHandler = new Handler(Looper.getMainLooper());

    }

    @Override
    public void login(String userID, String password) {

        presenterView.logingProgressVisibity(View.VISIBLE);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenterView.loginSuccess();
                presenterView.logingProgressVisibity(View.GONE);
            }
        }, 1000);

    }


    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

package com.example.herve.materialvideo.ui.login.presenter;

import com.example.herve.materialvideo.base.BasePresenter;
import com.example.herve.materialvideo.base.BasePresenterView;
import com.example.herve.materialvideo.ui.film.presenter.VideoContract;

/**
 * Created           :Herve on 2016/8/10.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/10
 * @ projectName     :MaterialVideo
 * @ version
 */
public class LoginContrart {

    public interface presenter extends BasePresenter {

        void login(String userID, String password);


    }

    public interface presenterView extends BasePresenterView<VideoContract.Presenter> {

        void logingProgressVisibity(int visibity);

        void loginSuccess();

        void loginFail(int errorCode);

    }
}

package com.example.herve.materialvideo.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.base.BaseActivity;
import com.example.herve.materialvideo.ui.film.presenter.VideoContract;
import com.example.herve.materialvideo.ui.home.HomeActivity;
import com.example.herve.materialvideo.ui.login.presenter.LoginContrart;
import com.example.herve.materialvideo.ui.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginContrart.presenterView {


    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.at_email)
    AutoCompleteTextView atEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button emailSignInButton;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R.id.login_form)
    ScrollView loginForm;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;

    private final String TAG = getClass().getSimpleName();

    private Context mContext;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mContext = this;
        initUI();
        initData();

        initListener();
    }


    private void initUI() {


    }

    private void initData() {
        loginPresenter = new LoginPresenter(mContext, this);

    }

    private void initListener() {
        emailSignInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View focusView = null;

                String userID = atEmail.getText().toString();
                String password = etPassword.getText().toString();
                boolean cancel = false;

//                if (!TextUtils.isEmpty(userID) && !userID.contains("@")) {
//                    atEmail.setError(getString(R.string.error_field_required));
//                    focusView = atEmail;
//                    cancel = true;
//                } else {
//                    atEmail.setError(null);
//
//                }

                if (!cancel) {
                    loginPresenter.login(userID, password);
                } else {
                    if (focusView != null) {
                        focusView.requestFocus();
                    }
                }


            }
        });


    }

    @Override
    public void logingProgressVisibity(int visibity) {

        loginProgress.setVisibility(visibity);
    }

    @Override
    public void loginSuccess() {

        Snackbar.make(emailLoginForm, "登录成功！", Snackbar.LENGTH_SHORT).show();

        Intent intent = new Intent(mContext, HomeActivity.class);
        startActivity(intent);

    }


    @Override
    public void loginFail(int errorCode) {
        Snackbar.make(emailLoginForm, "登录失败！Code:" + errorCode, Snackbar.LENGTH_SHORT).show();
        atEmail.setError("请正确填写!");
    }


    @Override
    public void setPresenter(VideoContract.Presenter presenter) {

    }
}


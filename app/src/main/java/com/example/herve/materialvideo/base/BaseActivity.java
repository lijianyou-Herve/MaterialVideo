package com.example.herve.materialvideo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.example.herve.materialvideo.utils.sp.SharedPreferencesUtil;

/**
 * Created by Herve on 2016/7/30.
 */
public class BaseActivity extends AppCompatActivity {

    private SharedPreferencesUtil sharedPreferencesUtil;
    private String TAG = getClass().getSimpleName();

    private int themestyle;
    public BaseActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this);
        themestyle = sharedPreferencesUtil.getthemeStyles();

        Log.e(TAG, "onCreate: themestyle=" + themestyle);
        if (savedInstanceState == null) {
//            if (themestyle == 1) {
//                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
////                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//            } else {
//                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
////                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//            }
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {

        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onRestart() {
        if (themestyle == 1) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            sharedPreferencesUtil.putthemeStyles(0);
        }
        super.onRestart();
    }
}

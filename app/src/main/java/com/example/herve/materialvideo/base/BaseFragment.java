package com.example.herve.materialvideo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.herve.materialvideo.application.AppLication;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Herve on 2016/7/30.
 */
public class BaseFragment extends Fragment {

    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = AppLication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}

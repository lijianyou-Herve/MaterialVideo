package com.example.herve.materialvideo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.herve.materialvideo.application.AppLication;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Herve on 2016/7/30.
 */
public class BaseFragment extends Fragment {

    public FragmentActivity mContext;
    private String tittle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = AppLication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}

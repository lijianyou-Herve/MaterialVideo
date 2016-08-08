package com.example.herve.materialvideo.ui.home.fragments.VIPFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.ui.home.fragments.baseHomeFragment.BackHandledFragment;

/**
 * Created by Herve on 2016/6/19.
 */
public class VIPFragment extends BackHandledFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vip, null);

        return view;
    }

    @Override
    public String getTagText() {
        return null;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}

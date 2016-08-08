package com.example.herve.materialvideo.ui.home.fragments.favoriteFragment;

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
public class FavoriteFragment extends BackHandledFragment {

    private String TAG = getClass().getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite, null);

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

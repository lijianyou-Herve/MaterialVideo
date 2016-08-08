package com.example.herve.materialvideo.ui.home.fragments.filmFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.application.AppLication;
import com.example.herve.materialvideo.ui.film.VideoActivity;
import com.example.herve.materialvideo.ui.home.fragments.baseHomeFragment.BackHandledFragment;
import com.example.herve.materialvideo.ui.home.fragments.filmFragment.adapter.FilmFragmentAdapter;
import com.example.herve.materialvideo.ui.home.fragments.filmFragment.presenter.FilmFragmentContract;
import com.example.herve.materialvideo.ui.home.fragments.filmFragment.presenter.FilmFragmetPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class FilmFragmen extends BackHandledFragment implements FilmFragmentContract.PresentenrView {

    @BindView(R.id.bbs_recyclerView)
    RecyclerView bbsRecyclerView;
    @BindView(R.id.bbs_swipeRefreshLayout)
    SwipeRefreshLayout bbsSwipeRefreshLayout;
    @BindView(R.id.film_progress)
    ProgressBar filmProgress;

    private FilmFragmetPresenter presentenr;
    private FilmFragmentAdapter mVideoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_square_list, null);

        ButterKnife.bind(this, view);

        initView();

        initData();

        initListener();

        return view;
    }

    private void initView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);

        bbsRecyclerView.setLayoutManager(layoutManager);

        bbsRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initListener() {
        bbsSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                presentenr.reFreshData();

            }
        });
    }

    private void initData() {
        filmProgress.setVisibility(View.VISIBLE);
        presentenr = new FilmFragmetPresenter(this, mContext);
        mVideoAdapter = new FilmFragmentAdapter(mContext, presentenr);
        bbsRecyclerView.setAdapter(mVideoAdapter);
    }

    @Override
    public String getTagText() {
        return null;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent = new Intent(getActivity(), VideoActivity.class);
        intent.putExtra("url", AppLication.urls[position]);
        Pair<View, String> pair = new Pair<>(view.findViewById(R.id.iv_film_cover), getString(R.string.transition_book_img));
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), pair);

        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());

    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {

        if (visiblity == View.VISIBLE) {
            filmProgress.setVisibility(visiblity);

            bbsSwipeRefreshLayout.setRefreshing(true);

        } else {
            filmProgress.setVisibility(visiblity);

            bbsSwipeRefreshLayout.setRefreshing(false);
            mVideoAdapter.notifyDataSetChanged();

        }

    }

    @Override
    public void setPresenter(FilmFragmentContract.Presentenr presenter) {

    }
}

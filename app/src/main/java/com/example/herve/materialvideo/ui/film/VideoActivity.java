package com.example.herve.materialvideo.ui.film;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.base.BaseActivity;
import com.example.herve.materialvideo.data.bean.preson.Person;
import com.example.herve.materialvideo.ui.film.adapter.FilmPageFragmentAdapter;
import com.example.herve.materialvideo.ui.film.fragments.BlankFragment;
import com.example.herve.materialvideo.ui.film.fragments.BlankThreeFragment;
import com.example.herve.materialvideo.ui.film.fragments.BlankTwoFragment;
import com.example.herve.materialvideo.ui.film.presenter.DataBean;
import com.example.herve.materialvideo.ui.film.presenter.ItemBean;
import com.example.herve.materialvideo.ui.film.presenter.VideoContract;
import com.example.herve.materialvideo.ui.film.presenter.VideoPresenter;
import com.example.herve.materialvideo.utils.fastjson.FastJsonParser;
import com.example.herve.materialvideo.utils.fastjson.TestDataManager;
import com.example.herve.materialvideo.widget.imageloader.ijkplayer.widget.media.IjkVideoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoActivity extends BaseActivity implements VideoContract.PresenterView {


    @BindView(R.id.ijkPlayer)
    IjkVideoView ijkPlayer;
    @BindView(R.id.ivImage)
    ImageView ivImage;
    @BindView(R.id.loading_progress)
    ProgressBar loadingProgress;
    @BindView(R.id.rl_video_root)
    RelativeLayout rlVideoRoot;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.vp_progress)
    ProgressBar vpProgress;
    private String url;
    private String TAG = getClass().getSimpleName();
    private VideoPresenter videoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);

        initUI();
        initData();
        initListener();
    }

    private void initListener() {
        ijkPlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer mp, int what, int extra) {
                Toast.makeText(mContext, "视频无法播放", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        ijkPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer mp) {
                Log.e(TAG, "onPrepared: onPrepared视频准备完毕");
                ijkPlayer.start();
                loadingProgress.setVisibility(View.GONE);
                ivImage.setVisibility(View.GONE);

            }
        });

    }

    private void videoStart() {
        loadingProgress.setVisibility(View.VISIBLE);
        ijkPlayer.setVideoURI(Uri.parse(url));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //Configuration.ORIENTATION_LANDSCAPE，Configuration.ORIENTATION_PORTRAIT
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        }
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }

    }

    private void initData() {
        collapsingToolbar.setTitle("视频详情");
        url = getIntent().getStringExtra("url");
        ijkPlayer.changeAspectRaito(0);
        Glide.with(ivImage.getContext())
                .load(R.mipmap.videoimage)
                .fitCenter()
                .into(ivImage);

        videoPresenter = new VideoPresenter(this, mContext, url);
        videoPresenter.initData();
    }

    private void initUI() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        ijkPlayer.setBackgroundColor(Color.parseColor("#ca3f3f"));
        ijkPlayer.changeAspectRaito(1);
        ijkPlayer.enterBackground();

        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    public void play(View view) {

        ijkPlayer.start();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ijkPlayer.setVisibility(View.GONE);
            if (!ijkPlayer.isBackgroundPlayEnabled()) {
                ijkPlayer.stopPlayback();
                ijkPlayer.release(true);
                ijkPlayer.stopBackgroundPlay();

            }
            IjkMediaPlayer.native_profileEnd();
            ivImage.setVisibility(View.VISIBLE);

        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (!ijkPlayer.isBackgroundPlayEnabled()) {
            ijkPlayer.stopPlayback();
            ijkPlayer.release(true);
            ijkPlayer.stopBackgroundPlay();
        }
        IjkMediaPlayer.native_profileEnd();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ijkPlayer.setVisibility(View.GONE);

        if (!ijkPlayer.isBackgroundPlayEnabled()) {
            ijkPlayer.stopPlayback();
            ijkPlayer.release(true);
            ijkPlayer.stopBackgroundPlay();
        }
        IjkMediaPlayer.native_profileEnd();
        ivImage.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onPause() {
        super.onPause();
        ijkPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ijkPlayer.resume();
    }

    @Override
    public void initData(DataBean dataBean) {
        for (ItemBean itemBean : dataBean.getItemBean()) {
            tabLayout.addTab(tabLayout.newTab().setText(itemBean.getTitle()));
        }

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new BlankFragment());
        fragments.add(new BlankTwoFragment());
        fragments.add(new BlankThreeFragment());
        FilmPageFragmentAdapter filmPageFragmentAdapter = new FilmPageFragmentAdapter(getSupportFragmentManager(), fragments, dataBean.getItemBean());
        viewpager.setAdapter(filmPageFragmentAdapter);
        tabLayout.setupWithViewPager(viewpager);
        videoStart();


        Person person = TestDataManager.newPerson();
        Log.i(TAG, "initData: person=" + person.toString());

        String json = FastJsonParser.getInstance().toJson(person);

        Log.i(TAG, "initData: json=" + json);
        Person person2 = FastJsonParser.getInstance().fromJson(json, Person.class);

        Log.i(TAG, "initData: person=" + person2.toString());


    }

    @Override
    public void reFresh() {

    }

    @Override
    public void VideoViewVisibity(int visibity) {
        loadingProgress.setVisibility(visibity);

    }

    @Override
    public void ViewPagerVisibity(int visibity) {
        vpProgress.setVisibility(visibity);
    }

    @Override
    public void setPresenter(VideoContract.Presenter presenter) {

    }
}

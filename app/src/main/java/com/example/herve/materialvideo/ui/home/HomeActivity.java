package com.example.herve.materialvideo.ui.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.base.BaseActivity;
import com.example.herve.materialvideo.base.BaseFragment;
import com.example.herve.materialvideo.ui.home.fragments.VIPFragment.VIPFragment;
import com.example.herve.materialvideo.ui.home.fragments.baseHomeFragment.BackHandledFragment;
import com.example.herve.materialvideo.ui.home.fragments.bbsFragment.BbsFragment;
import com.example.herve.materialvideo.ui.home.fragments.favoriteFragment.FavoriteFragment;
import com.example.herve.materialvideo.ui.home.fragments.filmFragment.FilmFragment;
import com.example.herve.materialvideo.ui.home.fragments.settingFragment.SettingFragment;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.SquareListFragment;
import com.example.herve.materialvideo.ui.home.fragments.wealthFragment.WealthFragment;
import com.example.herve.materialvideo.ui.home.presenter.HomeContract;
import com.example.herve.materialvideo.ui.home.presenter.HomePresenter;
import com.example.herve.materialvideo.utils.sp.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeContract.PresenterView, NavigationView.OnNavigationItemSelectedListener, BackHandledFragment.BackHandlerInterface {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.frame_content)
    FrameLayout frameContent;


    private HomeContract.Presenter presenter;
    private List<BaseFragment> baseFragmentList;
    private BackHandledFragment backHandledFragment;
    private String TAG = "Herve" + getClass().getSimpleName();

    private SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();

        initListener();


    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {

        toolbar.setTitle("");
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    private void initData() {
        baseFragmentList = new ArrayList<>();
        baseFragmentList.add(new SquareListFragment());
        baseFragmentList.add(new FilmFragment());
        baseFragmentList.add(new WealthFragment());
        baseFragmentList.add(new FavoriteFragment());
        baseFragmentList.add(new VIPFragment());
        baseFragmentList.add(new BbsFragment());
        baseFragmentList.add(new SettingFragment());
        presenter = new HomePresenter(this, mContext);
        presenter.transitionFragments(baseFragmentList.get(0));
    }

    private void initListener() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferencesUtil = SharedPreferencesUtil.getInstance(mContext);
                int themestyle = sharedPreferencesUtil.getthemeStyles();

                if (themestyle == 0) {

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sharedPreferencesUtil.putthemeStyles(1);
                } else {

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sharedPreferencesUtil.putthemeStyles(0);

                }

                for (Fragment temp : baseFragmentList) {
                    if (temp.isAdded()) {
                        getSupportFragmentManager().beginTransaction().remove(temp).commit();
                    }

                }


                recreate();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_community) {
            presenter.transitionFragments(baseFragmentList.get(0));
        } else if (id == R.id.nav_video) {
            presenter.transitionFragments(baseFragmentList.get(1));

        } else if (id == R.id.nav_workcollet) {
            presenter.transitionFragments(baseFragmentList.get(2));

        } else if (id == R.id.nav_reward) {
            presenter.transitionFragments(baseFragmentList.get(3));

        } else if (id == R.id.nav_vip) {
            presenter.transitionFragments(baseFragmentList.get(4));

        } else if (id == R.id.nav_bbs) {
            presenter.transitionFragments(baseFragmentList.get(5));

        } else if (id == R.id.nav_set) {
            presenter.transitionFragments(baseFragmentList.get(6));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setSelectedFragment(BackHandledFragment backHandledFragment) {
        this.backHandledFragment = backHandledFragment;
    }

    @Override
    public void reloadFragment(Fragment fragment) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }
}

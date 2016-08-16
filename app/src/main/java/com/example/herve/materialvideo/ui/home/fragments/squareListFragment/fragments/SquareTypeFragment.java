package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.base.BaseFragment;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.adapter.SquareDataAdapter;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.adapter.SquareDataAdapterTest;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.BannerBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareFilmBean;
import com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model.SquareListData;
import com.example.herve.materialvideo.widget.imageloader.ImageLoader;
import com.example.herve.materialvideo.widget.imageloader.ImageLoaderUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created           :Herve on 2016/8/13.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/13
 * @ projectName     :MaterialVideo
 * @ version
 */
public class SquareTypeFragment extends BaseFragment {


    //    @BindView(R.id.iv_banner)
//    AppCompatImageView ivBanner;
    @BindView(R.id.iv_banner)
    ImageView ivBanner;
    @BindView(R.id.ll_ban_root)
    RelativeLayout llBanRoot;
    @BindView(R.id.square_recycle_view)
    RecyclerView squareRecycleView;
    private String TAG = getClass().getSimpleName();
    private ViewGroup rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView != null) {
            return rootView;
        }
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_square_type, null);
        ButterKnife.bind(this, rootView);


        List<SquareFilmBean> squareFilmBeens = new ArrayList<SquareFilmBean>();

        for (int i1 = 0; i1 < 10; i1++) {
            squareFilmBeens.add(new SquareFilmBean("第" + i1 + "个", "视频内容", "视频封面", 100, "作者", false, 10));
        }
        SquareListData squareListData = new SquareListData(2, getTittle(), new BannerBean("imageurl", "pagurl"), squareFilmBeens);

        initdata(squareListData);
        return rootView;
    }


    private void initdata(final SquareListData squareListData) {


        final SquareDataAdapterTest squareDataAdapter = new SquareDataAdapterTest(mContext, squareListData.getFilmBeanList());

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, 2);
        squareRecycleView.setLayoutManager(layoutManager);
        squareRecycleView.setItemAnimator(new DefaultItemAnimator());
//        squareRecycleView.addItemDecoration(new RecycleViewDivider(mContext,GridLayoutManager.VERTICAL,R.drawable.recycle_view_item_decoration));
        squareRecycleView.setAdapter(squareDataAdapter);


        ImageLoader imageLoader = new ImageLoader.Builder().resource(R.mipmap.film_cover).imgView(ivBanner).build();
//            ImageLoader imageLoader = new ImageLoader.Builder().url(squareFilmBean.getFilmCoverurl()).imgView(ivFilmCover).build();
        ImageLoaderUtil.getInstance().loadImage(mContext, imageLoader);


    }


    @Override
    public String getTittle() {
        return super.getTittle();
    }

    @Override
    public void setTittle(String tittle) {
        super.setTittle(tittle);
    }


}

package com.example.herve.materialvideo.ui.home.fragments.filmFragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.ui.home.fragments.filmFragment.presenter.FilmFragmetPresenter;
import com.example.herve.materialvideo.utils.Utils;
import com.example.herve.materialvideo.widget.imageloader.ImageLoader;
import com.example.herve.materialvideo.widget.imageloader.ImageLoaderUtil;

/**
 * Created by Herve on 2016/6/19.
 */
public class FilmFragmentAdapter extends RecyclerView.Adapter<FilmFragmentAdapter.ViewHolder> {
    public FilmFragmetPresenter filmFragmetPresenter;
    private Context mContext;

    private boolean animateItems = true;
    private int ANIMATED_ITEMS_COUNT = 3;
    private int lastAnimatedPosition = -1;
    private String TAG = getClass().getSimpleName();

    public FilmFragmentAdapter(Context mContext, FilmFragmetPresenter mVideoPresenter) {
        this.mContext = mContext;
        filmFragmetPresenter = mVideoPresenter;

    }

    public void updateItems( FilmFragmetPresenter mVideoPresenter, boolean animated) {
        animateItems = animated;
        lastAnimatedPosition = -1;
        filmFragmetPresenter.datas.addAll((mVideoPresenter).datas);
        notifyDataSetChanged();
    }

    public void clearItems() {
        filmFragmetPresenter.datas.clear();
        notifyDataSetChanged();
    }

    public String getItem(int position) {
        return filmFragmetPresenter.datas.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        ImageLoader imageLoader =new ImageLoader.Builder().resource(R.mipmap.videoimage).imgView(viewHolder.iv_film_cover).build();
        ImageLoaderUtil.getInstance().loadImage(mContext,imageLoader);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FilmFragmentAdapter.ViewHolder holder, final int position) {
        runEnterAnimation(holder.itemView, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filmFragmetPresenter.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmFragmetPresenter.datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView iv_film_cover;

        public ViewHolder(View v) {
            super(v);
            iv_film_cover = (ImageView) v.findViewById(R.id.iv_film_cover);

        }
    }

    private void runEnterAnimation(View view, int position) {
        if (!animateItems || position >= ANIMATED_ITEMS_COUNT - 1) {
            return;
        }

        if (position > lastAnimatedPosition) {
            Log.e(TAG, "runEnterAnimation: 有效动画");
            lastAnimatedPosition = position;
            view.setTranslationY(Utils.getScreenHeight(mContext));
            view.animate()
                    .translationY(0)
                    .setStartDelay(100 * position)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(700)
                    .start();
        }
    }
}

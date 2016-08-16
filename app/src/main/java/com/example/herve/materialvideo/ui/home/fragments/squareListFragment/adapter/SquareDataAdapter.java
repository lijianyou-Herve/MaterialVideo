package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.herve.materialvideo.R;
import com.example.herve.materialvideo.data.bean.bjxbean.SquareTypeContentBean;
import com.example.herve.materialvideo.widget.imageloader.ImageLoader;
import com.example.herve.materialvideo.widget.imageloader.ImageLoaderUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created           :Herve on 2016/8/14.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/14
 * @ projectName     :MaterialVideo
 * @ version
 */
public class SquareDataAdapter extends RecyclerView.Adapter<SquareDataAdapter.ViewHolder> {


    private Context mContext;
    private List<SquareTypeContentBean> filmBeanList;

    public SquareDataAdapter(Context mContext, List<SquareTypeContentBean> squareTypeGroupBeens) {
        this.mContext = mContext;
        this.filmBeanList = squareTypeGroupBeens;
    }


    private
    @LayoutRes
    int provideItemLayout() {
        // todo
        return R.layout.item_square_type;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(provideItemLayout(), parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.bind(filmBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return filmBeanList == null ? 0 : filmBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_film_cover)
        AppCompatImageView ivFilmCover;
        @BindView(R.id.tv_film_name)
        AppCompatTextView tvFilmName;
        @BindView(R.id.tv_film_author)
        AppCompatTextView tvFilmAuthor;
        @BindView(R.id.tv_film_play_count)
        AppCompatTextView tvFilmPlayCount;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //todo
        }

        public void bind(SquareTypeContentBean squareFilmBean) {

            String filmCoverUrl = "http://bj.bcebos.com/v1/tomato-dev/" + squareFilmBean.getUserId() + "/" + "filmElement/" + squareFilmBean.getFilmId() + ".jpg";
            Log.i("filmCoverUrl", "bind: "+filmCoverUrl);
            ImageLoader imageLoader = new ImageLoader.Builder().url(filmCoverUrl).imgView(ivFilmCover).build();
//            ImageLoader imageLoader = new ImageLoader.Builder().url(squareFilmBean.getFilmCoverurl()).imgView(ivFilmCover).build();
            ImageLoaderUtil.getInstance().loadImage(mContext, imageLoader);

            tvFilmName.setText(squareFilmBean.getFilmName());
            tvFilmAuthor.setText(squareFilmBean.getNickName());
            tvFilmPlayCount.setText(squareFilmBean.getPlayCount() + "");


            // todo
        }
    }

}
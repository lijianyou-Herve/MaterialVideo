package com.example.herve.materialvideo.view.customviews.baseview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

/**
 * Created           :Herve on 2016/8/14.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/14
 * @ projectName     :MaterialVideo
 * @ version
 */
public class CustomRecyclerView extends RecyclerView {


    private Context mContext;
    private View heandView;

    private OnItemClickListener onIiemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private Adapter adapter;

    public CustomRecyclerView(Context context) {
        super(context);
        mContext = context;
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;

    }


    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        this.adapter=adapter;
    }

    @Override
    public void removeView(View view) {
        if (view == heandView) {
            return;
        }
        super.removeView(view);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
    }


    public void addHeadView(View view) {
        LayoutManager layoutManager = new LinearLayoutManager(mContext);
        setLayoutManager(layoutManager);
        heandView = view;
        ((ViewGroup) this).addView(view, 0);
    }


    @Override
    public void addView(final View child, final int index) {
        if (onIiemClickListener != null) {
            child.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onIiemClickListener.onItemClick(CustomRecyclerView.this, child, index, child.getId());

                }
            });
        }
        if (onItemLongClickListener != null) {
            child.setOnLongClickListener(new OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {

                    onItemLongClickListener.onItemLongClickListener(CustomRecyclerView.this, child, index, child.getId());
                    return false;
                }
            });
        }
        super.addView(child, index);
    }

    public void setOnIiemClickListener(OnItemClickListener onIiemClickListener) {
        this.onIiemClickListener = onIiemClickListener;

    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;

    }


    public interface OnItemClickListener {
        void onItemClick(ViewGroup parent, View view, int position, long id);
    }

    public interface OnItemLongClickListener {
        void onItemLongClickListener(ViewGroup parent, View view, int position, long id);
    }
}

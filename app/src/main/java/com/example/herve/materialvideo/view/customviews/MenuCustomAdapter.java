package com.example.herve.materialvideo.view.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.herve.materialvideo.R;

import java.util.List;



public class MenuCustomAdapter extends BaseAdapter {

    private Context mContext;

    private List<MakeFilmMenuBean> data;

    private String TAG = getClass().getSimpleName();
    private int dmw;
    private int dmh;
    private float scale = 1.7f;

    public MenuCustomAdapter(Context mContext, List<MakeFilmMenuBean> data, int dmw, int dmh) {
        this.mContext = mContext;
        this.data = data;
        this.dmw = dmw;
        this.dmh = dmh;
    }

    public MenuCustomAdapter(Context mContext, List<MakeFilmMenuBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MakeFilmMenuBean itemBean = data.get(position);
        ViewHolder viewHolder;



        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.make_film_item_layout, null);
            viewHolder = new ViewHolder(convertView);

//            convertView.setLayoutParams(UI.getGridViewPararmW2(dmw, dmh, (int) (itemHeight * scale)));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        viewHolder.iv_film_type.setLayoutParams(UI.getLinearLayoutPararmW2(dmw, dmh, itemHeight));

        viewHolder.iv_film_type.setImageResource(itemBean.getIv_film_type());

        viewHolder.tv_film_type.setText(itemBean.getTv_film_type());

        return convertView;

    }

    class ViewHolder {
        private ImageView iv_film_type;
        private TextView tv_film_type;

        public ViewHolder(View view) {

            iv_film_type = (ImageView) view.findViewById(R.id.iv_film_type);
            tv_film_type = (TextView) view.findViewById(R.id.tv_film_type);
        }
    }

}


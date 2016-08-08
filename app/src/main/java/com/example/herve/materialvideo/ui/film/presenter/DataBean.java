package com.example.herve.materialvideo.ui.film.presenter;

import java.util.List;

/**
 * Created by Herve on 2016/8/7.
 */
public class DataBean {

    private List<ItemBean> itemBean;


    public List<ItemBean> getItemBean() {
        return itemBean;
    }

    public void setItemBean(List<ItemBean> itemBean) {
        this.itemBean = itemBean;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "itemBean=" + itemBean +
                '}';
    }
}

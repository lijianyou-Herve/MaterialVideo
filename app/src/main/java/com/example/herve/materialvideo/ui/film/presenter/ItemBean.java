package com.example.herve.materialvideo.ui.film.presenter;

/**
 * Created by Herve on 2016/8/7.
 */
public class ItemBean {
    private String title;
    private String data;

    public ItemBean() {
    }

    public ItemBean(String title, String data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "title='" + title + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}

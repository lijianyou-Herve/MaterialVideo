package com.example.herve.materialvideo.view.customviews;

/**
 * Created by Herve on 2016/5/18.
 */
public class MakeFilmMenuBean {

    private int iv_film_type;
    private int tv_film_type;

    public MakeFilmMenuBean(int iv_film_type, int tv_film_type) {
        this.iv_film_type = iv_film_type;
        this.tv_film_type = tv_film_type;
    }

    public int getIv_film_type() {
        return iv_film_type;
    }

    public void setIv_film_type(int iv_film_type) {
        this.iv_film_type = iv_film_type;
    }

    public int getTv_film_type() {
        return tv_film_type;
    }

    public void setTv_film_type(int tv_film_type) {
        this.tv_film_type = tv_film_type;
    }
}

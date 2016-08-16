package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model;

import java.util.List;

/**
 * Created           :Herve on 2016/8/13.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/13
 * @ projectName     :MaterialVideo
 * @ version
 */
public class SquareListData {

    private int position;
    private String tittle;
    private BannerBean bannerBean;
    private List<SquareFilmBean> filmBeanList;


    public SquareListData(int position, String tittle, BannerBean bannerBean, List<SquareFilmBean> videoBeanList) {
        this.position = position;
        this.tittle = tittle;
        this.bannerBean = bannerBean;
        this.filmBeanList = videoBeanList;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public BannerBean getBannerBean() {
        return bannerBean;
    }

    public void setBannerBean(BannerBean bannerBean) {
        this.bannerBean = bannerBean;
    }

    public List<SquareFilmBean> getFilmBeanList() {
        return filmBeanList;
    }

    public void setFilmBeanList(List<SquareFilmBean> filmBeanList) {
        this.filmBeanList = filmBeanList;
    }
}

package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.model;

/**
 * Created           :Herve on 2016/8/13.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/13
 * @ projectName     :MaterialVideo
 * @ version
 */
public class BannerBean {

    private String imageUrl;
    private String pageUrl;

    public BannerBean(String imageUrl, String pageUrl) {
        this.imageUrl = imageUrl;
        this.pageUrl = pageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
}

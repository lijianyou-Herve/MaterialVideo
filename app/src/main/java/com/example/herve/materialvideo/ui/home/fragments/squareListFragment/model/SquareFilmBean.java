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
public class SquareFilmBean {
    private String filmName;
    private String filmInfo;
    private String filmCoverurl;
    private int filmLength;
    private String filmAuthor;
    private boolean isVip;
    private int playCount;

    public SquareFilmBean(String filmName, String filmInfo, String filmCoverurl, int filmLength, String filmAuthor, boolean isVip, int playCount) {
        this.filmName = filmName;
        this.filmInfo = filmInfo;
        this.filmCoverurl = filmCoverurl;
        this.filmLength = filmLength;
        this.filmAuthor = filmAuthor;
        this.isVip = isVip;
        this.playCount = playCount;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }

    public String getFilmCoverurl() {
        return filmCoverurl;
    }

    public void setFilmCoverurl(String filmCoverurl) {
        this.filmCoverurl = filmCoverurl;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(int filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmAuthor() {
        return filmAuthor;
    }

    public void setFilmAuthor(String filmAuthor) {
        this.filmAuthor = filmAuthor;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }
}

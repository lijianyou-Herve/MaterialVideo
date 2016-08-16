package com.example.herve.materialvideo.data.bean.bilibili;

public class BannerDataBean {
    /**
     * face : http://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg
     * mid : 11153765
     * name : 哔哩哔哩音乐台
     */

    private OwnerBean owner;
    /**
     * src : http://i0.hdslb.com/bfs/live/98c268f907705241a3e3face25ae365e3120406b.png
     * height : 180
     * width : 320
     */

    private CoverBean cover;
    private String title;
    private int room_id;
    private int check_version;
    private int online;
    private String area;
    private int area_id;
    private String playurl;
    private String accept_quality;
    private int broadcast_type;
    private int is_tv;

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public CoverBean getCover() {
        return cover;
    }

    public void setCover(CoverBean cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getCheck_version() {
        return check_version;
    }

    public void setCheck_version(int check_version) {
        this.check_version = check_version;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    public String getAccept_quality() {
        return accept_quality;
    }

    public void setAccept_quality(String accept_quality) {
        this.accept_quality = accept_quality;
    }

    public int getBroadcast_type() {
        return broadcast_type;
    }

    public void setBroadcast_type(int broadcast_type) {
        this.broadcast_type = broadcast_type;
    }

    public int getIs_tv() {
        return is_tv;
    }

    public void setIs_tv(int is_tv) {
        this.is_tv = is_tv;
    }


}
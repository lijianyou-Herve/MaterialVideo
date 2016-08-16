package com.example.herve.materialvideo.data.bean.bjxbean;

import java.util.List;

public class SquareBannerBean {
    /**
     * bannerId : 10
     * bannerCode : 20160523-00010
     * bannerType : 1
     * bannerUrl : http://zhongchu.uning.tv:9999/bjxMng_test/Home/shareManual/index/type/100.html
     * bannerCoverUrl : http://wylyunying.bj.bcebos.com/00000000-0000-0000-0000-000000000000/baner/20160523-00010.png
     */

    private List<SquareBannerContentBean> squareBannerContent;

    public List<SquareBannerContentBean> getSquareBannerContent() {
        return squareBannerContent;
    }

    public void setSquareBannerContent(List<SquareBannerContentBean> squareBannerContent) {
        this.squareBannerContent = squareBannerContent;
    }


}

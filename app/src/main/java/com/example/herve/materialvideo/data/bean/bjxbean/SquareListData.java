package com.example.herve.materialvideo.data.bean.bjxbean;

import java.util.List;

/**
 * Created           :Herve on 2016/8/16.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/16
 * @ projectName     :MaterialVideo
 * @ version
 */
public class SquareListData {

    /**
     * result : 1
     * message : 获取成功
     * squareBanner : {"squareBannerContent":[{"bannerId":"10","bannerCode":"20160523-00010","bannerType":"1","bannerUrl":"http://zhongchu.uning.tv:9999/bjxMng_test/Home/shareManual/index/type/100.html","bannerCoverUrl":"http://wylyunying.bj.bcebos.com/00000000-0000-0000-0000-000000000000/baner/20160523-00010.png"},{"bannerId":"20","bannerCode":"20160621-00020","bannerType":"1","bannerUrl":"http://mp.weixin.qq.com/s?__biz=MzA5NjM2Mzg0Mw==&mid=503027679&idx=1&sn=51e38b41494484dbe3c590dd64beb876#rd","bannerCoverUrl":"http://wylyunying.bj.bcebos.com/00000000-0000-0000-0000-000000000000/baner/20160621-00020.png"},{"bannerId":"22","bannerCode":"20160812-00022","bannerType":"1","bannerUrl":"http://114.251.168.162:8888/notify/","bannerCoverUrl":"http://wylyunying.bj.bcebos.com/00000000-0000-0000-0000-000000000000/baner/20160812-00022.jpg"}]}
     * squareTypeGroup : [{"date":"","squareTypeContent":[{"orderId":"530","filmName":"yyyyy3","filmLength":"79","filmId":"6d4f8f07-577d-4112-8ba1-7da093212424","userId":"774e3ef0-f59e-4152-987d-f822feee8980","nickName":"王志新1","filmDesc":"g","userVIP":"1","playCount":"14"},{"orderId":"528","filmName":"t","filmLength":"20","filmId":"3bf70d02-698b-4401-a4ff-66e0297d9086","userId":"774e3ef0-f59e-4152-987d-f822feee8980","nickName":"王志新1","filmDesc":"痛苦","userVIP":"1","playCount":"15"},{"orderId":"526","filmName":"0483","filmLength":"17","filmId":"aadf0c12-2907-4450-8232-2bcd61cdb620","userId":"774e3ef0-f59e-4152-987d-f822feee8980","nickName":"王志新1","filmDesc":"@","userVIP":"1","playCount":"7"},{"orderId":"516","filmName":"切片切片切片","filmLength":"12","filmId":"d05abc71-fcd4-46af-bc3e-09caeb6a04ff","userId":"f3ce4a04-5608-11e5-b557-f99d29f3488e","nickName":"Metal","filmDesc":"不保额","userVIP":"1","playCount":"480"},{"orderId":"514","filmName":"q，","filmLength":"71","filmId":"d4fad8e0-2d34-4892-83d1-6ab78788a909","userId":"774e3ef0-f59e-4152-987d-f822feee8980","nickName":"王志新1","filmDesc":"5","userVIP":"1","playCount":"327"},{"orderId":"236","filmName":"落版","filmLength":"10","filmId":"762fbd31-01e4-436b-93b0-1d66e090b589","userId":"51b32bb2-e7ba-4631-837b-578968f9b2d1","nickName":"红丽","filmDesc":"111","userVIP":"1","playCount":"134"},{"orderId":"20","filmName":"Let's GO","filmLength":"13","filmId":"bf8c160f-c229-4fc1-ba0a-c0906a0c8afd","userId":"b762c912-d564-4ce1-a122-ee0cf4f6fb46","nickName":"Perve","filmDesc":"aaa","userVIP":"1","playCount":"395"},{"orderId":"16","filmName":"擎天柱微视频","filmLength":"30","filmId":"28f4f024-1681-4aff-ae84-7d2b74cc1533","userId":"2d4990a0-bdb9-11e5-96db-008cfae40bc8","nickName":"1819北京弯月","filmDesc":"嗯谢谢","userVIP":"0","playCount":"174"}]}]
     */

    private int result;
    private String message;
    private SquareBannerBean squareBanner;
    /**
     * date :
     * squareTypeContent : [{"orderId":"530","filmName":"yyyyy3","filmLength":"79","filmId":"6d4f8f07-577d-4112-8ba1-7da093212424","userId":"774e3ef0-f59e-4152-987d-f822feee8980","nickName":"王志新1","filmDesc":"g","userVIP":"1","playCount":"14"},{"orderId":"528","filmName":"t","filmLength":"20","filmId":"3bf70d02-698b-4401-a4ff-66e0297d9086","userId":"774e3ef0-f59e-4152-987d-f822feee8980","nickName":"王志新1","filmDesc":"痛苦","userVIP":"1","playCount":"15"},{"orderId":"526","filmName":"0483","filmLength":"17","filmId":"aadf0c12-2907-4450-8232-2bcd61cdb620","userId":"774e3ef0-f59e-4152-987d-f822feee8980","nickName":"王志新1","filmDesc":"@","userVIP":"1","playCount":"7"},{"orderId":"516","filmName":"切片切片切片","filmLength":"12","filmId":"d05abc71-fcd4-46af-bc3e-09caeb6a04ff","userId":"f3ce4a04-5608-11e5-b557-f99d29f3488e","nickName":"Metal","filmDesc":"不保额","userVIP":"1","playCount":"480"},{"orderId":"514","filmName":"q，","filmLength":"71","filmId":"d4fad8e0-2d34-4892-83d1-6ab78788a909","userId":"774e3ef0-f59e-4152-987d-f822feee8980","nickName":"王志新1","filmDesc":"5","userVIP":"1","playCount":"327"},{"orderId":"236","filmName":"落版","filmLength":"10","filmId":"762fbd31-01e4-436b-93b0-1d66e090b589","userId":"51b32bb2-e7ba-4631-837b-578968f9b2d1","nickName":"红丽","filmDesc":"111","userVIP":"1","playCount":"134"},{"orderId":"20","filmName":"Let's GO","filmLength":"13","filmId":"bf8c160f-c229-4fc1-ba0a-c0906a0c8afd","userId":"b762c912-d564-4ce1-a122-ee0cf4f6fb46","nickName":"Perve","filmDesc":"aaa","userVIP":"1","playCount":"395"},{"orderId":"16","filmName":"擎天柱微视频","filmLength":"30","filmId":"28f4f024-1681-4aff-ae84-7d2b74cc1533","userId":"2d4990a0-bdb9-11e5-96db-008cfae40bc8","nickName":"1819北京弯月","filmDesc":"嗯谢谢","userVIP":"0","playCount":"174"}]
     */

    private List<SquareTypeGroupBean> squareTypeGroup;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SquareBannerBean getSquareBanner() {
        return squareBanner;
    }

    public void setSquareBanner(SquareBannerBean squareBanner) {
        this.squareBanner = squareBanner;
    }

    public List<SquareTypeGroupBean> getSquareTypeGroup() {
        return squareTypeGroup;
    }

    public void setSquareTypeGroup(List<SquareTypeGroupBean> squareTypeGroup) {
        this.squareTypeGroup = squareTypeGroup;
    }


}

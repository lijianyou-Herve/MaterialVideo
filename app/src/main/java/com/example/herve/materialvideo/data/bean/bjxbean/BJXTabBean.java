package com.example.herve.materialvideo.data.bean.bjxbean;

import java.util.List;

/**
 * Created           :Herve on 2016/8/15.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/15
 * @ projectName     :MaterialVideo
 * @ version
 */
public class BJXTabBean {

    /**
     * result : 1
     * message : 获取成功
     * squareType : [{"squareTypeId":"2","squareTypeName":"生活"},{"squareTypeId":"3","squareTypeName":"商业"},{"squareTypeId":"4","squareTypeName":"微信视频"},{"squareTypeId":9999,"squareTypeName":"最新"}]
     */

    private int result;
    private String message;
    /**
     * squareTypeId : 2
     * squareTypeName : 生活
     */

    private List<SquareTypeBean> squareType;

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

    public List<SquareTypeBean> getSquareType() {
        return squareType;
    }

    public void setSquareType(List<SquareTypeBean> squareType) {
        this.squareType = squareType;
    }


    @Override
    public String toString() {
        return "BJXTabBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", squareType=" + squareType.get(0).toString() +
                '}';
    }
}

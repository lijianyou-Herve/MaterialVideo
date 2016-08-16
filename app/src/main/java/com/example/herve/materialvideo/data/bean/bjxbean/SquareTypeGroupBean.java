package com.example.herve.materialvideo.data.bean.bjxbean;

import java.util.List;

public  class SquareTypeGroupBean {
        private String date;
        /**
         * orderId : 530
         * filmName : yyyyy3
         * filmLength : 79
         * filmId : 6d4f8f07-577d-4112-8ba1-7da093212424
         * userId : 774e3ef0-f59e-4152-987d-f822feee8980
         * nickName : 王志新1
         * filmDesc : g
         * userVIP : 1
         * playCount : 14
         */

        private List<SquareTypeContentBean> squareTypeContent;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<SquareTypeContentBean> getSquareTypeContent() {
            return squareTypeContent;
        }

        public void setSquareTypeContent(List<SquareTypeContentBean> squareTypeContent) {
            this.squareTypeContent = squareTypeContent;
        }

       
    }
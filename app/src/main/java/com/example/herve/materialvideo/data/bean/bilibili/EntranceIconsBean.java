package com.example.herve.materialvideo.data.bean.bilibili;

public  class EntranceIconsBean {
            private int id;
            private String name;
            /**
             * src : http://static.hdslb.com/live-static/images/mobile/android/big/xxhdpi/11_big.png?2016081501
             * height : 132
             * width : 132
             */

            private EntranceIconBean entrance_icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public EntranceIconBean getEntrance_icon() {
                return entrance_icon;
            }

            public void setEntrance_icon(EntranceIconBean entrance_icon) {
                this.entrance_icon = entrance_icon;
            }

            
        }
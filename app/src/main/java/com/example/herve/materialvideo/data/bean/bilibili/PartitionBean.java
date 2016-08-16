package com.example.herve.materialvideo.data.bean.bilibili;

public  class PartitionBean {
                private int id;
                private String name;
                private String area;
                /**
                 * src : http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?2016081501
                 * height : 63
                 * width : 63
                 */

                private SubIconBean sub_icon;
                private int count;

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

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public SubIconBean getSub_icon() {
                    return sub_icon;
                }

                public void setSub_icon(SubIconBean sub_icon) {
                    this.sub_icon = sub_icon;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

               
            }
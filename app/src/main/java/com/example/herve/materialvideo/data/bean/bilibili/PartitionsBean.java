package com.example.herve.materialvideo.data.bean.bilibili;

import java.util.List;

public  class PartitionsBean {
            /**
             * id : 9
             * name : 绘画专区
             * area : draw
             * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?2016081501","height":"63","width":"63"}
             * count : 175
             */

            private PartitionBean partition;
            /**
             * owner : {"face":"http://i0.hdslb.com/bfs/face/1fc686f94c90d1fa691db447309f113ea9a7b4a1.jpg","mid":2863756,"name":"半边丶扑克脸"}
             * cover : {"src":"http://i0.hdslb.com/bfs/live/f19785571c66ecd3a07ffa191e908bfd97f82440.jpg","height":180,"width":320}
             * title : 画了个画
             * room_id : 982286
             * check_version : 0
             * online : 10
             * area : 绘画专区
             * area_id : 9
             * playurl : http://live-play.acgvideo.com/live/739/live_2863756_5518852.flv?wsSecret=a81a1efc073bac666319e26179a3710d&wsTime=578a12bb
             * accept_quality : 4
             * broadcast_type : 0
             * is_tv : 0
             */

            private List<LivesBean> lives;

            public PartitionBean getPartition() {
                return partition;
            }

            public void setPartition(PartitionBean partition) {
                this.partition = partition;
            }

            public List<LivesBean> getLives() {
                return lives;
            }

            public void setLives(List<LivesBean> lives) {
                this.lives = lives;
            }




        }
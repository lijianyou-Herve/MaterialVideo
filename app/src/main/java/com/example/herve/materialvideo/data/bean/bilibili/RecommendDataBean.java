package com.example.herve.materialvideo.data.bean.bilibili;

import java.util.List;

public  class RecommendDataBean {
            /**
             * id : 0
             * name : 推荐主播
             * area : hot
             * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/-1.png?2016081501","height":"63","width":"63"}
             * count : 3633
             */

            private PartitionBean partition;
            /**
             * owner : {"face":"http://i1.hdslb.com/bfs/face/4e8cad07713ce0ded34dba3f4c56da680f6ba979.jpg","mid":1864366,"name":"黑哲君丶"}
             * cover : {"src":"http://i0.hdslb.com/bfs/live/7b253562cbf8b88cb1b306e2127fbb48e16fc189.jpg","height":180,"width":320}
             * title : b站第一提百万打野 你感受过绝望吗
             * room_id : 83264
             * check_version : 0
             * online : 9974
             * area : 电子竞技
             * area_id : 4
             * playurl : http://live-play.acgvideo.com/live/330/live_1864366_1171676.flv?wsSecret=fa5279c40d1102a9dd07a85d6795b44c&wsTime=578a12bb
             * accept_quality : 4
             * broadcast_type : 0
             * is_tv : 0
             */

            private List<LivesBean> lives;
            /**
             * owner : {"face":"http://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","mid":11153765,"name":"哔哩哔哩音乐台"}
             * cover : {"src":"http://i0.hdslb.com/bfs/live/98c268f907705241a3e3face25ae365e3120406b.png","height":180,"width":320}
             * title : 【官方】哔哩哔哩官方音乐台
             * room_id : 23058
             * check_version : 0
             * online : 8857
             * area : 放映厅
             * area_id : 7
             * playurl : http://live-play.acgvideo.com/live/945/live_11153765_9369560.flv?wsSecret=2cefe135346fab621fe7405c98d53d0b&wsTime=578a12bb
             * accept_quality : 4
             * broadcast_type : 0
             * is_tv : 0
             */

            private List<BannerDataBean> banner_data;

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

            public List<BannerDataBean> getBanner_data() {
                return banner_data;
            }

            public void setBanner_data(List<BannerDataBean> banner_data) {
                this.banner_data = banner_data;
            }

            
            

            
        }

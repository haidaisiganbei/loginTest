package com.example.qwang.logintest.Model;

import java.util.List;

/**
 * Created by QWang on 2017/12/28.
 */

public class NewsResponse {
    /**
     * status : 0
     * msg : ok
    */

    private String status;
    private String msg;
    private ResultEntity result;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public ResultEntity getResult() {
        return result;
    }

    public static class ResultEntity {
        /**
         * channel : 头条
         * num : 10
        */

        private String channel;
        private String num;
        private List<ListEntity> list;

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public String getChannel() {
            return channel;
        }

        public String getNum() {
            return num;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public static class ListEntity {
            /**
             * title : 阿富汗喀布尔新闻机构附近发生爆炸 至少40人死亡
             * time : 2017-12-28 15:37
             * src : 环球网
             * category : news
             * pic :
             * content :  原标题：阿富汗喀布尔新闻机构附近发生爆炸 至少40人死亡</p>  [环球网综合报道]据法新社12月28日报道，阿富汗内政部官员表示，阿富汗首都喀布尔一座清真寺与“阿富汗之声”新闻社附近发生爆炸，目前已造成至少40人死亡。</p>
             * url : http://news.sina.cn/gj/2017-12-28/detail-ifyqchnr6758743.d.html?vt=4&pos=108
             * weburl : http://news.sina.com.cn/w/2017-12-28/doc-ifyqchnr6758743.shtml
             */

            private String title;
            private String time;
            private String src;
            private String category;
            private String pic;
            private String content;
            private String url;
            private String weburl;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }

            public String getTitle() {
                return title;
            }

            public String getTime() {
                return time;
            }

            public String getSrc() {
                return src;
            }

            public String getCategory() {
                return category;
            }

            public String getPic() {
                return pic;
            }

            public String getContent() {
                return content;
            }

            public String getUrl() {
                return url;
            }

            public String getWeburl() {
                return weburl;
            }
        }
    }
}

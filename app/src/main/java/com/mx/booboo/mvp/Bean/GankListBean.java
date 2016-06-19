package com.mx.booboo.mvp.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 */
public class GankListBean {


    /**
     * count : 10
     * error : false
     * results : [{"desc":"还在用ListView？","publishedAt":"2016-05-12T12:04:43.857000","readability":"ssssssssssssssss","type":"Android","url":"http://www.jianshu.com/p/a92955be0a3e","who":"陈宇明"}]
     */

    private int count;
    private boolean error;
    /**
     * desc : 还在用ListView？
     * publishedAt : 2016-05-12T12:04:43.857000
     * readability : ssssssssssssssss
     * type : Android
     * url : http://www.jianshu.com/p/a92955be0a3e
     * who : 陈宇明
     */

    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String desc;
        private String publishedAt;
        private String readability;
        private String type;
        private String url;
        private String who;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getReadability() {
            return readability;
        }

        public void setReadability(String readability) {
            this.readability = readability;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}

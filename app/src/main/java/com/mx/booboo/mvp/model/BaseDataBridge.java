package com.mx.booboo.mvp.model;

import com.mx.booboo.mvp.Bean.JokePicBean;
import com.mx.booboo.mvp.Bean.JokeTextBean;
import com.mx.booboo.mvp.Bean.NewsListInfo;
import com.mx.booboo.mvp.Bean.TabNameInfo;
import com.mx.booboo.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public interface BaseDataBridge<T> {

    void addData(List<T> datas);

    void error();

    interface TabNewsData extends BaseDataBridge<TabNewsInfo> {
    }

    interface TabNameData extends BaseDataBridge<TabNameInfo> {
    }

    interface NewsListData extends BaseDataBridge<NewsListInfo> {
    }



    ////////////////////////////////////////////////////////
    interface JokeTextList extends BaseDataBridge<JokeTextBean.JokeTextInfo>{

    }

    interface JokePicList extends BaseDataBridge<JokePicBean.JokePicInfo>{

    }
}

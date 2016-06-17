package com.mx.booboo.mvp.presenter;

import com.mx.booboo.mvp.Bean.JokeTextBean;
import com.mx.booboo.mvp.Bean.NewsListInfo;

/**
 * Created by hww on 2016/6/16.
 */
public interface BasePresenter {

    interface TabNamePresenter {
        void requestNetWork();
    }

    interface TabNewsPresenter {
        void requestNetWork();
    }

    interface  NewsListPresenter{
        void requestNetWork(int id,int page,boolean isNull);
        void onClick(NewsListInfo info);
    }




    ////////////////////////////////////////////////////
    interface  JokeTextPresenter{
        void requestNetWork(int page,boolean isNull);
    }


}

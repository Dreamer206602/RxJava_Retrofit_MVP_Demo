package com.mx.booboo.network;

import com.mx.booboo.mvp.Bean.BaseBean;
import com.mx.booboo.mvp.Bean.JokeTextBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/6.
 */
public class NetWorkRequest {

    public static void tabName(Subscriber<BaseBean.TabNameBean> subscriber) {
        Network.getTngouApi().getTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabNews(Subscriber<BaseBean.TabNewsBean> subscriber) {
        Network.getTngouApi().getTabNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void newsList(int id,int page,Subscriber<BaseBean.NewsListBean>subscriber){
        Network.getTngouApi().getNewsList(id,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }



    //////////////////////////////////////////////////////////////////////
    public static void jokeTextList(int page, Subscriber<JokeTextBean>subscriber){
        Network.getBaiDuApi().getJokeText(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }





}

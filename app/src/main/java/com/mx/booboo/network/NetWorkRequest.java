package com.mx.booboo.network;

import com.mx.booboo.mvp.Bean.BaseBean;

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





}

package com.mx.booboo.network;


import com.mx.booboo.mvp.Bean.BaseBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * by y on 2016/5/17.
 */
public interface TngouApi {


    @GET(Api.TAB_NEWS)
    Observable<BaseBean.TabNewsBean> getTabNews();


    @GET(Api.TAB_NAME)
    Observable<BaseBean.TabNameBean> getTabName();



}

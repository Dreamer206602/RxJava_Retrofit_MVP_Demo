package com.mx.booboo.network;

import com.mx.booboo.mvp.Bean.GankListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/20.
 */
public interface GankApi {


    @GET(Api.GANK)
    Observable<GankListBean>getGankList(@Query("page")int page);


}

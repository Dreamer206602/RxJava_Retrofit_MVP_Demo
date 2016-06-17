package com.mx.booboo.network;



import com.mx.booboo.mvp.Bean.JokeTextBean;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by y on 2016/5/30.
 */
public interface BaiDuApi {

    @GET(Api.JOKE_TEXT)
    @Headers(Api.BAIDU_KEY)
    Observable<JokeTextBean> getJokeText(@Query("page") int page);
//
//    @GET(Api.JOKE_PIC)
//    @Headers(Api.BAIDU_KEY)
//    Observable<JokePicBean> getJokePic(@Query("page") int page);

}

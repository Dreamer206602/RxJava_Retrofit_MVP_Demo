package com.mx.booboo.mvp.model;

import com.mx.booboo.mvp.Bean.JokeTextBean;
import com.mx.booboo.network.NetWorkRequest;

import rx.Subscriber;

/**
 * Created by hww on 2016/6/17.
 */
public class JokeTextModelImpl implements BaseModel.JokeTextModel {
    @Override
    public void netWorkList(int page, final BaseDataBridge.JokeTextList jokeTextList) {
        NetWorkRequest.jokeTextList(page, new Subscriber<JokeTextBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                jokeTextList.error();

            }

            @Override
            public void onNext(JokeTextBean jokeTextBean) {
                jokeTextList.addData(jokeTextBean.getShowapi_res_body().getContentlist());

            }
        });


    }
}

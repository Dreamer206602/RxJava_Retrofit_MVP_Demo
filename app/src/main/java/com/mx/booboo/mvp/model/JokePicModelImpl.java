package com.mx.booboo.mvp.model;

import com.mx.booboo.mvp.Bean.JokePicBean;
import com.mx.booboo.network.MySubscriber;
import com.mx.booboo.network.NetWorkRequest;

/**
 * Created by Administrator on 2016/6/19.
 */
public class JokePicModelImpl implements BaseModel.JokePicModel {

    @Override
    public void netWorkList(int page, final BaseDataBridge.JokePicList jokePicList) {
        NetWorkRequest.jokePicList(page,new MySubscriber<JokePicBean>(){
            @Override
            public void onError(Throwable e) {
                jokePicList.error();
            }

            @Override
            public void onNext(JokePicBean jokePicBean) {
                jokePicList.addData(jokePicBean.getShowapi_res_body().getContentlist());
            }
        });

    }
}

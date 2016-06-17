package com.mx.booboo.mvp.model;

import com.mx.booboo.mvp.Bean.BaseBean;
import com.mx.booboo.network.MySubscriber;
import com.mx.booboo.network.NetWorkRequest;

/**
 * Created by hww on 2016/6/16.
 */
public class TabNewsModelImpl implements BaseModel.TabNewsModel {
    @Override
    public void netWork(final BaseDataBridge.TabNewsData model) {
        NetWorkRequest.tabNews(new MySubscriber<BaseBean.TabNewsBean>(){
            @Override
            public void onError(Throwable e) {
                model.error();
            }

            @Override
            public void onNext(BaseBean.TabNewsBean tabNewsBean) {
               model.addData(tabNewsBean.getInfo());

            }
        });
    }
}

package com.mx.booboo.mvp.model;

import com.mx.booboo.mvp.Bean.BaseBean;
import com.mx.booboo.network.MySubscriber;
import com.mx.booboo.network.NetWorkRequest;

/**
 * Created by hww on 2016/6/16.
 */
public class TabNameModelImpl implements BaseModel.TabNameModel {
    @Override
    public void netWork(final BaseDataBridge.TabNameData model) {
        NetWorkRequest.tabName(new MySubscriber<BaseBean.TabNameBean>(){

            @Override
            public void onError(Throwable e) {
                model.error();
            }

            @Override
            public void onNext(BaseBean.TabNameBean tabNameBean) {
                model.addData(tabNameBean.getInfo());
            }
        });
    }
}

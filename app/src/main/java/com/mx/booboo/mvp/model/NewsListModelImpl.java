package com.mx.booboo.mvp.model;

import com.mx.booboo.mvp.Bean.BaseBean;
import com.mx.booboo.network.MySubscriber;
import com.mx.booboo.network.NetWorkRequest;

/**
 * Created by hww on 2016/6/16.
 */
public class NewsListModelImpl implements BaseModel.NewsListModel {
    @Override
    public void netWorkNewList(int id, int page, final BaseDataBridge.NewsListData newsListData) {
        NetWorkRequest.newsList(id,page,new MySubscriber<BaseBean.NewsListBean>(){
            @Override
            public void onError(Throwable e) {
                newsListData.error();
            }

            @Override
            public void onNext(BaseBean.NewsListBean newsListBean) {
                newsListData.addData(newsListBean.getInfo());

            }
        });
    }
}

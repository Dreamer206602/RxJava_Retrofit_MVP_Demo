package com.mx.booboo.mvp.model;

/**
 * Created by hww on 2016/6/16.
 */
public interface BaseModel<T> {

    void netWork(T model);

    interface TabNewsModel extends BaseModel<BaseDataBridge.TabNewsData> {
    }

    interface TabNameModel extends BaseModel<BaseDataBridge.TabNameData> {
    }
}

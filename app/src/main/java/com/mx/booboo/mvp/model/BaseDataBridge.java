package com.mx.booboo.mvp.model;

import com.mx.booboo.mvp.Bean.TabNameInfo;
import com.mx.booboo.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public interface BaseDataBridge<T> {

    void addData(List<T> datas);

    void error();

    interface TabNewsData extends BaseDataBridge<TabNewsInfo> {
    }

    interface TabNameData extends BaseDataBridge<TabNameInfo> {
    }
}

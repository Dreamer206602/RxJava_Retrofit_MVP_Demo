package com.mx.booboo.mvp.view;

import com.mx.booboo.mvp.Bean.TabNameInfo;
import com.mx.booboo.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public interface BaseView<T> {

    void setData(List<T> datas);

    void netWorkError();

    void hideProgress();

    void showProgress();

    void showFoot();

    void hideFoot();

    interface TabNameView extends BaseView<TabNameInfo> {
    }

    interface TabNewsView extends BaseView<TabNewsInfo> {
    }
}

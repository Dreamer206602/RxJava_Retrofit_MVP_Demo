package com.mx.booboo.mvp.Bean;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public class BaseBean<T> {
    private List<T> tngou;


    public List<T> getInfo() {
        return tngou;
    }

    public void setInfo(List<T> tngou) {
        this.tngou = tngou;
    }

    public class TabNewsBean extends BaseBean<TabNewsInfo> {
    }

    public class TabNameBean extends BaseBean<TabNameInfo> {
    }

}

package com.mx.booboo.mvp.presenter;

/**
 * Created by hww on 2016/6/16.
 */
public class BasePresenterImpl<T> {
    T view;

    public BasePresenterImpl(T view) {
        this.view = view;
    }
}

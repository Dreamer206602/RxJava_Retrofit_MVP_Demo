package com.mx.booboo.mvp.presenter;

import com.mx.booboo.mvp.Bean.TabNewsInfo;
import com.mx.booboo.mvp.model.BaseDataBridge;
import com.mx.booboo.mvp.model.BaseModel;
import com.mx.booboo.mvp.model.TabNewsModelImpl;
import com.mx.booboo.mvp.view.BaseView;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public class TabNewsPresenterImpl extends BasePresenterImpl<BaseView.TabNewsView>
        implements BasePresenter.TabNewsPresenter,BaseDataBridge.TabNewsData{
    private BaseModel.TabNewsModel mTabNewsModel;


    public TabNewsPresenterImpl(BaseView.TabNewsView view) {
        super(view);
        this.mTabNewsModel=new TabNewsModelImpl();
    }

    @Override
    public void addData(List<TabNewsInfo> datas) {
        view.setData(datas);

    }

    @Override
    public void error() {
        view.netWorkError();
    }

    @Override
    public void requestNetWork() {
        mTabNewsModel.netWork(this);

    }
}

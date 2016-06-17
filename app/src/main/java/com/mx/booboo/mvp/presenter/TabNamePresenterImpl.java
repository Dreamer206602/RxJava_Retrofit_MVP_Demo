package com.mx.booboo.mvp.presenter;

import com.mx.booboo.mvp.Bean.TabNameInfo;
import com.mx.booboo.mvp.model.BaseDataBridge;
import com.mx.booboo.mvp.model.BaseModel;
import com.mx.booboo.mvp.model.TabNameModelImpl;
import com.mx.booboo.mvp.view.BaseView;

import java.util.List;

/**
 * Created by hww on 2016/6/17.
 */
public class TabNamePresenterImpl extends BasePresenterImpl<BaseView.TabNameView> implements
        BasePresenter.TabNamePresenter,BaseDataBridge.TabNameData{

    private BaseModel.TabNameModel mTabNameModel;
    public TabNamePresenterImpl(BaseView.TabNameView view) {
        super(view);
        this.mTabNameModel=new TabNameModelImpl();
    }

    @Override
    public void addData(List<TabNameInfo> datas) {
        view.setData(datas);
    }

    @Override
    public void error() {
        view.netWorkError();

    }


    @Override
    public void requestNetWork() {
        mTabNameModel.netWork(this);


    }
}

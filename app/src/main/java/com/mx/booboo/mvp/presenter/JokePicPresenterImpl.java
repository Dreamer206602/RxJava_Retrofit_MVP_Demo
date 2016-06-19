package com.mx.booboo.mvp.presenter;

import com.mx.booboo.mvp.Bean.JokePicBean;
import com.mx.booboo.mvp.model.BaseDataBridge;
import com.mx.booboo.mvp.model.BaseModel;
import com.mx.booboo.mvp.model.JokePicModelImpl;
import com.mx.booboo.mvp.view.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2016/6/19.
 */
public class JokePicPresenterImpl extends BasePresenterImpl<BaseView.JokePicView> implements
        BaseDataBridge.JokePicList,BasePresenter.JokePicPresenter{
    private BaseModel.JokePicModel mJokePicModel;
    public JokePicPresenterImpl(BaseView.JokePicView view) {
        super(view);
        this.mJokePicModel=new JokePicModelImpl();
    }

    @Override
    public void addData(List<JokePicBean.JokePicInfo> datas) {
        view.setData(datas);
    }

    @Override
    public void error() {
        view.netWorkError();

    }

    @Override
    public void requestNetWork(int page) {
        mJokePicModel.netWorkList(page,this);

    }
}

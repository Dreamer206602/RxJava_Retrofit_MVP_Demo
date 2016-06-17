package com.mx.booboo.mvp.presenter;

import com.mx.booboo.mvp.Bean.JokeTextBean;
import com.mx.booboo.mvp.model.BaseDataBridge;
import com.mx.booboo.mvp.model.BaseModel;
import com.mx.booboo.mvp.model.JokeTextModelImpl;
import com.mx.booboo.mvp.view.BaseView;

import java.util.List;

/**
 * Created by hww on 2016/6/17.
 */
public class JokeTextPresenterImpl extends BasePresenterImpl<BaseView.JokeTextView> implements BasePresenter.JokeTextPresenter,
        BaseDataBridge.JokeTextList{

    private BaseModel.JokeTextModel mJokeTextModel;
    public JokeTextPresenterImpl(BaseView.JokeTextView view) {
        super(view);
        mJokeTextModel=new JokeTextModelImpl();
    }

    @Override
    public void addData(List<JokeTextBean.JokeTextInfo> datas) {

        view.setData(datas);
        view.hideFoot();
        view.hideProgress();

    }

    @Override
    public void error() {
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();

    }

    //BasePresenter
    @Override
    public void requestNetWork(int page, boolean isNull) {

        if (page == 1) {
            view.showProgress();
        } else {
            if (!isNull) {
                view.showFoot();
            }
        }
        mJokeTextModel.netWorkList(page, this);

    }
}

package com.mx.booboo.mvp.presenter;

import com.mx.booboo.mvp.Bean.NewsListInfo;
import com.mx.booboo.mvp.model.BaseDataBridge;
import com.mx.booboo.mvp.model.BaseModel;
import com.mx.booboo.mvp.model.NewsListModelImpl;
import com.mx.booboo.mvp.view.BaseView;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public class NewsListPresenterImpl extends BasePresenterImpl<BaseView.NewsListView> implements
     BasePresenter.NewsListPresenter,BaseDataBridge.NewsListData{

    private BaseModel.NewsListModel mNewsListModel;

    public NewsListPresenterImpl(BaseView.NewsListView view) {
        super(view);
        this.mNewsListModel=new NewsListModelImpl();
    }


    @Override
    public void addData(List<NewsListInfo> datas) {
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

    @Override
    public void requestNetWork(int id, int page, boolean isNull) {
//        if(page==1){
//            view.showProgress();
//        }else{
//            if(!isNull){
//                view.showFoot();
//            }
//        }
        mNewsListModel.netWorkNewList(id,page,this);

    }

    @Override
    public void onClick(NewsListInfo info) {
        //TODO 跳转到详情的界面

    }
}

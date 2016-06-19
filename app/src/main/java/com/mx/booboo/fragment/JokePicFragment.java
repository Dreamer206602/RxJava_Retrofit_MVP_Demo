package com.mx.booboo.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.mx.booboo.R;
import com.mx.booboo.adapter.JokePicAdapter;
import com.mx.booboo.constant.Constant;
import com.mx.booboo.mvp.Bean.JokePicBean;
import com.mx.booboo.mvp.presenter.BasePresenter;
import com.mx.booboo.mvp.presenter.JokePicPresenterImpl;
import com.mx.booboo.mvp.view.BaseView;
import com.mx.booboo.utils.LogUtils;
import com.mx.booboo.utils.UIUtils;
import com.mx.booboo.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokePicFragment extends BaseFragment implements BaseView.JokePicView, SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.LoadingData {

    private BasePresenter.JokePicPresenter mJokePicPresenter;

    @Bind(R.id.recyclerView)
    MyRecyclerView mRecyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private JokePicAdapter mJokePicAdapter;
    private List<JokePicBean.JokePicInfo>mInfos;
    private static  int page =1;

    View ret;


    @Override
    protected View initView() {

        if (ret == null) {
        ret=View.inflate(UIUtils.getActivity(), R.layout.fragment_joke_pic, null);
    }
        return ret;
    }

    @Override
    protected void initData() {
        mJokePicPresenter=new JokePicPresenterImpl(this);

        mInfos=new ArrayList<>();
        mJokePicAdapter=new JokePicAdapter(mInfos);


        mSwipeRefreshLayout.setColorSchemeColors(
                UIUtils.getColor(R.color.colorAccent),
                UIUtils.getColor(R.color.colorPrimary)
        );
        mSwipeRefreshLayout.setOnRefreshListener(this);


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLoadingData(this);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mJokePicAdapter);


        Observable.timer(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        onRefresh();
                       mSwipeRefreshLayout.setRefreshing(false);
                    }
                });

    }


    @Override
    public void setData(List<JokePicBean.JokePicInfo> datas) {
        LogUtils.d("JokePic",datas.get(0).getImg());
        mJokePicAdapter.addAll(datas);
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
//        if(mSwipeRefreshLayout.isRefreshing()){
//            mSwipeRefreshLayout.setRefreshing(false);
//        }


    }

    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing(true);
//        if(!mSwipeRefreshLayout.isRefreshing())
//        {
//            mSwipeRefreshLayout.setRefreshing(true);
//        }


    }

    @Override
    public void showFoot() {
        mJokePicAdapter.isShowFooter(true);
    }

    @Override
    public void hideFoot() {
        mJokePicAdapter.isShowFooter(false);
    }

    @Override
    public void onRefresh() {
        mJokePicAdapter.removeAll();
        page=1;
        mJokePicPresenter.requestNetWork(page);


    }

    @Override
    public void onLoadMore() {
        if(!mSwipeRefreshLayout.isRefreshing()) {
            ++page;
            mJokePicPresenter.requestNetWork(page);
        }

    }
}

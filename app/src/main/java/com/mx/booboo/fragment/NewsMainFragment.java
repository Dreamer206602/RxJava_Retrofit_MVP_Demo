package com.mx.booboo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mx.booboo.R;
import com.mx.booboo.adapter.NewsListAdapter;
import com.mx.booboo.mvp.Bean.NewsListInfo;
import com.mx.booboo.mvp.presenter.BasePresenter;
import com.mx.booboo.mvp.presenter.NewsListPresenterImpl;
import com.mx.booboo.mvp.view.BaseView;
import com.mx.booboo.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsMainFragment extends BaseFragment implements BaseView.NewsListView,
        SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener {


    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private NewsListAdapter mListAdapter;
    private List<NewsListInfo>mListInfos;

    public static  int page=1;
    public static  boolean isNull=false;
    private BasePresenter.NewsListPresenter mNewsListPresenter;


    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_news_main, null);
    }

    @Override
    protected void initData() {
        mNewsListPresenter=new NewsListPresenterImpl(this);


        mListInfos=new ArrayList<>();
        mListAdapter=new NewsListAdapter(UIUtils.getActivity(),R.layout.news_list_item,mListInfos);





        mSwipeRefreshLayout.setOnRefreshListener(this);





    }

    public static NewsMainFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_INDEX, position);
        NewsMainFragment fragment = new NewsMainFragment();
        fragment.setArguments(bundle);
        return fragment;

    }


    @Override
    public void setData(List<NewsListInfo> datas) {
        if(datas.isEmpty()){
            isNull=true;
        }else{
            mListAdapter.addData(datas);

        }
        mRecyclerView.setAdapter(mListAdapter);



    }

    @Override
    public void netWorkError() {
        Toast("网络异常");

    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing(true);

    }

    @Override
    public void showFoot() {

    }

    @Override
    public void hideFoot() {
        mSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onRefresh() {

        Observable.timer(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                            mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
        page=1;
        mNewsListPresenter.requestNetWork(index+1,page,isNull);
        mListAdapter.notifyDataSetChanged();



    }

    @Override
    public void onLoadMoreRequested() {



    }
}

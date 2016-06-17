package com.mx.booboo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mx.booboo.R;
import com.mx.booboo.adapter.BaseRecyclerViewAdapter;
import com.mx.booboo.adapter.NewsListAdapter;
import com.mx.booboo.constant.Constant;
import com.mx.booboo.mvp.Bean.NewsListInfo;
import com.mx.booboo.mvp.presenter.BasePresenter;
import com.mx.booboo.mvp.presenter.NewsListPresenterImpl;
import com.mx.booboo.mvp.view.BaseView;
import com.mx.booboo.utils.LogUtils;
import com.mx.booboo.utils.UIUtils;
import com.mx.booboo.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsMainFragment extends BaseFragment implements BaseView.NewsListView,
        SwipeRefreshLayout.OnRefreshListener, BaseRecyclerViewAdapter.OnItemClickListener<NewsListInfo>,MyRecyclerView.LoadingData {


    @Bind(R.id.recyclerView)
    MyRecyclerView mRecyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private boolean isPrepared;
    private boolean isLoad;

    private View inflate;

    private NewsListAdapter mListAdapter;
    private List<NewsListInfo>mListInfos;

    public static  int page=1;
    public static  boolean isNull=false;
    private BasePresenter.NewsListPresenter mNewsListPresenter;


    @Override
    protected View initView() {
        if (inflate == null) {
            inflate = View.inflate(UIUtils.getActivity(), R.layout.fragment_news_main, null);
            isPrepared = true;
        }
        return inflate;
    }

    @Override
    protected void initData() {

        if (!isPrepared || !isVisible || isLoad) {
            return;
        }
        mNewsListPresenter=new NewsListPresenterImpl(this);

        mListInfos=new ArrayList<>();
        mListAdapter=new NewsListAdapter(mListInfos);

        mListAdapter.setOnItemClickListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLoadingData(this);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR,
                LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mListAdapter);


        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });

        isLoad = true;

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
        LogUtils.i("NewsMainFragment",datas.get(0).getDescription());
        if(datas.isEmpty()){
            isNull=true;
        }else{
            mListInfos.addAll(datas);
        }
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
        page=1;
        mListAdapter.removeAll();
        mNewsListPresenter.requestNetWork(index+1,page,isNull);
    }

    @Override
    public void onItemClick(View view, int position, NewsListInfo info) {

    }

    @Override
    public void onLoadMore() {

        if (!mSwipeRefreshLayout.isRefreshing()) {
            ++page;
            mNewsListPresenter.requestNetWork(index + 1, page, isNull);
        }

    }
}

package com.mx.booboo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mx.booboo.R;
import com.mx.booboo.adapter.BaseRecyclerViewAdapter;
import com.mx.booboo.adapter.JokeTextAdapter;
import com.mx.booboo.constant.Constant;
import com.mx.booboo.mvp.Bean.JokeTextBean;
import com.mx.booboo.mvp.presenter.BasePresenter;
import com.mx.booboo.mvp.presenter.JokeTextPresenterImpl;
import com.mx.booboo.mvp.view.BaseView;
import com.mx.booboo.utils.UIUtils;
import com.mx.booboo.widget.MyRecyclerView;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeTextFragment extends BaseFragment implements MyRecyclerView.LoadingData, SwipeRefreshLayout.OnRefreshListener,
        BaseView.JokeTextView, BaseRecyclerViewAdapter.OnItemLongClickListener<JokeTextBean.JokeTextInfo> {


    @Bind(R.id.recyclerView)
    MyRecyclerView mRecyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private boolean isPrepared;
    private boolean isLoad;
    private static boolean isNull = false;
    private static int page = 1;

    private View inflate;

    private BasePresenter.JokeTextPresenter mJokeTextPresenter;
    private JokeTextAdapter mJokeTextAdapter;

    @Override
    protected View initView() {

        if (inflate == null) {
            inflate = View.inflate(UIUtils.getActivity(), R.layout.fragment_joke_text, null);
            isPrepared = true;
        }
        return inflate;

    }

    @Override
    protected void initData() {


        if (!isPrepared || !isVisible || isLoad) {
            return;
        }

        mJokeTextPresenter = new JokeTextPresenterImpl(this);
        List<JokeTextBean.JokeTextInfo> jokeTextInfo = new LinkedList<>();

        mSwipeRefreshLayout.setOnRefreshListener(this);

        mJokeTextAdapter = new JokeTextAdapter(jokeTextInfo);
        mJokeTextAdapter.setOnLongClickListener(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLoadingData(this);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mJokeTextAdapter);

        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
        isLoad = true;
    }

    @Override
    public void onRefresh() {
        mJokeTextAdapter.removeAll();
        page = 1;
        mJokeTextPresenter.requestNetWork(page, isNull);
    }

    @Override
    public void onLoadMore() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
            ++page;
            mJokeTextPresenter.requestNetWork(page, isNull);
        }
    }

    @Override
    public void setData(List<JokeTextBean.JokeTextInfo> datas) {
        if (datas.isEmpty()) {
            isNull = true;
        } else {
            mJokeTextAdapter.addAll(datas);
        }
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
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
        mJokeTextAdapter.isShowFooter(true);
    }

    @Override
    public void hideFoot() {
        mJokeTextAdapter.isShowFooter(false);
    }

    @Override
    public void onLongClick(View view, int position, JokeTextBean.JokeTextInfo info) {
        //ActivityUtils.share(String.valueOf(Html.fromHtml(info.getText())));
    }

}

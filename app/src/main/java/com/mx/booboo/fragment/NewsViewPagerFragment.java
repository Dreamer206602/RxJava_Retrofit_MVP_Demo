package com.mx.booboo.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.mx.booboo.R;
import com.mx.booboo.adapter.TabNewsAdapter;
import com.mx.booboo.mvp.Bean.TabNewsInfo;
import com.mx.booboo.mvp.presenter.BasePresenter;
import com.mx.booboo.mvp.presenter.TabNewsPresenterImpl;
import com.mx.booboo.mvp.view.BaseView;
import com.mx.booboo.utils.LogUtils;
import com.mx.booboo.utils.UIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsViewPagerFragment extends BaseFragment implements BaseView.TabNewsView {


    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private List<TabNewsInfo> data;
    private TabNewsAdapter mTabNewsAdapter;


    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_news_view_pager, null);
    }

    @Override
    protected void initData() {

        BasePresenter.TabNewsPresenter presenter=new TabNewsPresenterImpl(this);
        presenter.requestNetWork();

        data =new LinkedList<>();
        mTabNewsAdapter=new TabNewsAdapter(getChildFragmentManager(), data);

    }


    @Override
    public void setData(List<TabNewsInfo> datas) {

        LogUtils.i("NewsViewPagerFragment",datas.get(0).getName());

        if(!datas.isEmpty()){
            data.addAll(datas);
            mViewPager.setAdapter(mTabNewsAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }

    }

    @Override
    public void netWorkError() {
        Toast("网络异常");

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showFoot() {

    }

    @Override
    public void hideFoot() {

    }
}

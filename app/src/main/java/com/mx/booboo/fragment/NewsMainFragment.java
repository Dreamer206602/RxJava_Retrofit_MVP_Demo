package com.mx.booboo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mx.booboo.R;
import com.mx.booboo.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsMainFragment extends BaseFragment {


    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_news_main, null);
    }

    @Override
    protected void initData() {

    }

    public static NewsMainFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_INDEX, position);
        NewsMainFragment fragment = new NewsMainFragment();
        fragment.setArguments(bundle);
        return fragment;

    }


}

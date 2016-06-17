package com.mx.booboo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mx.booboo.R;
import com.mx.booboo.adapter.TabJokeAdapter;
import com.mx.booboo.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeMainPagerFragment extends BaseFragment {

    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private TabJokeAdapter mTabJokeAdapter;


    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_joke_main_pager, null);
    }

    @Override
    protected void initData() {

        List<String> data = new LinkedList<>();
        data.add(UIUtils.getString(R.string.joke_text));
        data.add(UIUtils.getString(R.string.joke_pic));

        mTabJokeAdapter=new TabJokeAdapter(getChildFragmentManager(),data);
        mViewPager.setAdapter(mTabJokeAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


    }

}

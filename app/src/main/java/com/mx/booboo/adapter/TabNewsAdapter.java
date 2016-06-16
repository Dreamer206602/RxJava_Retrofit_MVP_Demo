package com.mx.booboo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mx.booboo.fragment.NewsMainFragment;
import com.mx.booboo.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public class TabNewsAdapter  extends BaseFragmentPagerAdapter<TabNewsInfo> {


    public TabNewsAdapter(FragmentManager fm, List<TabNewsInfo> mDatas) {
        super(fm, mDatas);
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return NewsMainFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(TabNewsInfo data) {
        return data.getName();
    }
}

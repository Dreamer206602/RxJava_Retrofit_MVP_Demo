package com.mx.booboo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mx.booboo.fragment.JokePicFragment;
import com.mx.booboo.fragment.JokeTextFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hww on 2016/6/17.
 */
public class TabJokeAdapter extends BaseFragmentPagerAdapter<String> {

    private List<Fragment>mFragments;
    public TabJokeAdapter(FragmentManager fm, List<String> mDatas) {
        super(fm, mDatas);
        mFragments=new ArrayList<>();
        mFragments.add(new JokeTextFragment());
        mFragments.add(new JokePicFragment());
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return mFragments.get(position);
    }

    @Override
    protected CharSequence getTitle(String data) {
        return data;
    }
}

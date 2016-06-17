package com.mx.booboo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mx.booboo.R;
import com.mx.booboo.utils.UIUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokePicFragment extends BaseFragment {

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(),R.layout.fragment_joke_pic,null);
    }

    @Override
    protected void initData() {

    }

}

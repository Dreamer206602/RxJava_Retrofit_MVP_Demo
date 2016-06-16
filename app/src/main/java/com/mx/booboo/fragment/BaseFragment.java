package com.mx.booboo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mx.booboo.utils.LogUtils;
import com.mx.booboo.utils.UIUtils;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by hww on 2016/6/16.
 */
public abstract class BaseFragment extends Fragment {

    boolean isVisible;
    static final String FRAGMENT_INDEX = "fragment_index";
    int index = 0;
    protected Subscription subscription;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            index = bundle.getInt(FRAGMENT_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = initView();
        ButterKnife.bind(this, view);
        LogUtils.i("BaseFragment", getClass().getSimpleName());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    void Toast(String content) {
        Toast.makeText(UIUtils.getContext(), content, Toast.LENGTH_LONG).show();
    }


    private void onVisible() {
        initData();
    }

    private void onInvisible() {
    }

    protected abstract View initView();

    protected abstract void initData();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        unsubscribe();
    }


    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}

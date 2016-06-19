package com.mx.booboo.fragment;


import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.mx.booboo.R;
import com.mx.booboo.utils.UIUtils;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {
    @Bind(R.id.et_search)
    EditText mEtSearch;
    @Bind(R.id.tv_result)
    TextView mTvResult;

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_search, null);
    }

    @Override
    protected void initData() {

        Observable<CharSequence>observableSearch= RxTextView.textChanges(mEtSearch);

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                mEtSearch.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String newText = s.toString().trim();
                        subscriber.onNext(newText);
                    }
                });
            }
        }).debounce(500, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                searchText(s);

            }
        });

    }

    private void searchText(String s) {
        if(!TextUtils.isEmpty(s)){
            mTvResult.setText("search:"+s);
        }
    }


}

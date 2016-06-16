package com.mx.booboo.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mx.booboo.mvp.Bean.NewsListInfo;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public class NewsListAdapter extends BaseQuickAdapter<NewsListInfo> {
    public NewsListAdapter(Context context, int layoutResId, List<NewsListInfo> data) {
        super(context, layoutResId, data);
    }

    public NewsListAdapter(Context context, List<NewsListInfo> data) {
        super(context, data);
    }

    public NewsListAdapter(Context context, View contentView, List<NewsListInfo> data) {
        super(context, contentView, data);
    }

    public NewsListAdapter(Context context) {
        super(context);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, NewsListInfo newsListInfo) {

    }
}

package com.mx.booboo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mx.booboo.R;
import com.mx.booboo.mvp.Bean.NewsListInfo;
import com.mx.booboo.network.Api;
import com.mx.booboo.utils.ImageLoaderUtils;
import com.mx.booboo.utils.TimeUtils;
import com.mx.booboo.utils.UIUtils;

import java.util.List;

/**
 * Created by hww on 2016/6/16.
 */
public class NewsListAdapter extends BaseQuickAdapter<NewsListInfo> {
    public NewsListAdapter(Context context, int layoutResId, List<NewsListInfo> data) {
        super(context, layoutResId, data);
    }

//    public NewsListAdapter(Context context, List<NewsListInfo> data) {
//        super(context, data);
//    }

//    public NewsListAdapter(Context context, View contentView, List<NewsListInfo> data) {
//        super(context, contentView, data);
//    }

//    public NewsListAdapter(Context context) {
//        super(context);
//    }

    @Override
    protected void convert(BaseViewHolder holder, NewsListInfo newsListInfo) {
       holder.setText(R.id.tv_time, UIUtils.getString(R.string.news_time)+
       TimeUtils.getDateToString(newsListInfo.getTime()))
               .setText(R.id.tv_title,newsListInfo.getTitle())
               .setText(R.id.tv_url,newsListInfo.getFromurl());

        ImageLoaderUtils.display(UIUtils.getContext(), (ImageView) holder.getView(R.id.image), Api.IMAGER_URL+newsListInfo.getImg());




    }
}

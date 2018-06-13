package com.example.android.sknews;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    private String mUrl;

    @Override
    protected void onStartLoading() {


        forceLoad();
    }

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl==null){
            return null;
        }
        List<News> news = FetchNews.fetchNewsFromJson(mUrl);
        return  news;
    }
}

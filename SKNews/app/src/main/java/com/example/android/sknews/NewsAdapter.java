package com.example.android.sknews;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class NewsAdapter extends ArrayAdapter<News>  {
    public NewsAdapter(@NonNull Context context,  @NonNull List<News> objects,int resource) {
        super(context, 0, objects);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }
        News currentNews = getItem(position);


        TextView textView = listItemView.findViewById(R.id.title);
        textView.setText(currentNews.getTitle());

        TextView desc = listItemView.findViewById(R.id.description);
        desc.setText(currentNews.getDescription());

        int radius = 30; // corner radius, higher value = more rounded
        int margin = 10; // crop margin, set to 0 for corners with no crop
        ImageView imgView = (ImageView) listItemView.findViewById(R.id.news_image);
        if(currentNews.getImageURL()==null){
            imgView.setImageResource(R.drawable.notfound);
        }else{
            Glide.with(getContext())
                    .load(currentNews.getImageURL())
                    .into(imgView);

        }


        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


}

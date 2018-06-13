package com.example.android.sknews;

import java.net.URL;

public class News {
    private String title;
    private String description;
    private String imageURL;
    private  String newsURL;

    public News(String title, String description,String image,String url) {
        this.title = title;
        this.description = description;
        this.imageURL = image;
        this.newsURL = url;
    }

    public String getNewsURL() {
        return newsURL;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }
}

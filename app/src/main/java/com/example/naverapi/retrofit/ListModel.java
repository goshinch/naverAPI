package com.example.naverapi.retrofit;

import com.google.gson.annotations.SerializedName;

public class ListModel {
    @SerializedName("title")
    String title;
    @SerializedName("link")
    String link;
    @SerializedName("description")
    String desc;
    @SerializedName("postdate")
    String postdate;

    public ListModel(String title, String link, String desc, String postdate) {
        this.title = title;
        this.link = link;
        this.desc = desc;
        this.postdate = postdate;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDesc() {
        return desc;
    }

    public String getPostdate() {
        return postdate;
    }
}

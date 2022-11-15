package com.example.naverapi.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {
    @SerializedName("lastBuildDate")
    String lastBuildDate;
    @SerializedName("total")
    String total;
    @SerializedName("start")
    String start;
    @SerializedName("display")
    String display;
    @SerializedName("items")
    List<ListModel> items;

    public Model(String lastBuildDate, String total, String start, String display, List<ListModel> items) {
        this.lastBuildDate = lastBuildDate;
        this.total = total;
        this.start = start;
        this.display = display;
        this.items = items;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public List<ListModel> getItems() {
        return items;
    }

    public void setItmes(List<ListModel> itmes) {
        this.items = itmes;
    }
}

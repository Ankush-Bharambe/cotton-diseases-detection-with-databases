package com.app;

public class FeedModal {
    private String headline ;
    private  String desc;
    private String date;


    public FeedModal(String headline, String desc, String date) {
        this.headline = headline;
        this.desc = desc;
        this.date = date;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

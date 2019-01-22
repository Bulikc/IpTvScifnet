package com.example.iptv;

public class M3U8 {
    private String name;
    private String group;
    private String pictureUrl;
    private String url;

    public M3U8(String name, String group, String pictureUrl, String url) {
        this.name = name;
        this.group = group;
        this.pictureUrl = pictureUrl;
        this.url = url;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}

package com.example.mywebsites;

import java.util.List;
import java.util.Map;

public class WebsitesPerCategory {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "URL: " + url + "\n";
    }
}

package com.example.mywebsites;

import java.util.ArrayList;

public class WebsitesPerCountry {

    private String country;
    private ArrayList<WebsitesPerCategory> websitesPerCountry;

    public WebsitesPerCountry() {
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public ArrayList<WebsitesPerCategory> getWebsitesPerCountry() {
        return websitesPerCountry;
    }

    public void setWebsitesPerCountry(ArrayList<WebsitesPerCategory> websitesPerCountry) {
        this.websitesPerCountry = websitesPerCountry;
    }

}

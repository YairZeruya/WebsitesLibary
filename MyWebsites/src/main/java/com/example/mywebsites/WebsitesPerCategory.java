package com.example.mywebsites;

import java.util.ArrayList;

public class WebsitesPerCategory {

    public class WebsitesForCategory {

        private String country;
        private String category;
        private ArrayList<String> urls;

        public WebsitesForCategory() {}

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }


        public String getCategory() {
            return category;
        }

        public void setCategory(String ctegory) {
            this.category = category;
        }

        public ArrayList<String> getWebsites() {
            return urls;
        }

        public void setWebsites(ArrayList<String> urls) {
            this.urls = urls;
        }
    }

}

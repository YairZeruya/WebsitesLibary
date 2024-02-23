package com.example.mywebsites;

import java.util.ArrayList;

public class WebsitesPerCategory {

    public class WebsitesForCategory {

        private String country;
        private String category;
        private ArrayList<String> urls;

        public WebsitesForCategory() {}

        private String getCountry() {
            return country;
        }

        private void setCountry(String country) {
            this.country = country;
        }


        private String getCategory() {
            return category;
        }

        private void setCategory(String ctegory) {
            this.category = category;
        }

        private ArrayList<String> getUrls() {
            return urls;
        }

        private void setUrls(ArrayList<String> urls) {
            this.urls = urls;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Country: ").append(country).append("\n");
            stringBuilder.append("Category: ").append(category).append("\n");
            stringBuilder.append("Websites:\n");
            for (String website : urls) {
                stringBuilder.append("- ").append(website).append("\n");
            }
            return stringBuilder.toString();
        }
    }

}

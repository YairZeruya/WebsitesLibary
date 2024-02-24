package com.example.mywebsites;

import java.util.List;
import java.util.Map;

public class WebsitesPerCategory {

    private Map<String, List<String>> websitesByCategory;

    public Map<String, List<String>> getWebsitesByCategory() {
        return websitesByCategory;
    }

    public void setWebsitesByCategory(Map<String, List<String>> websitesByCategory) {
        this.websitesByCategory = websitesByCategory;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (websitesByCategory != null) {
            for (Map.Entry<String, List<String>> entry : websitesByCategory.entrySet()) {
                stringBuilder.append(entry.getKey()).append(":").append("\n");
                List<String> websites = entry.getValue();
                for (String website : websites) {
                    stringBuilder.append("- ").append(website).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}

package com.example.websiteslibary;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mywebsites.WebsitesController;
import com.example.mywebsites.WebsitesPerCategory;

import java.util.List;

public class WebsitesActivity extends AppCompatActivity {
    private ListView listView;
    private TextView countryCategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        String country = getIntent().getStringExtra("country");
        String category = getIntent().getStringExtra("category");
        findViews();
        countryCategoryName.setText("Websites in " + country + " - " + category);
        getWebsitesByCountryAndCategory(country, category,listView);
    }

    private void findViews() {
        listView = findViewById(R.id.listViewWebsites);
        countryCategoryName = findViewById(R.id.countryCategoryName);
    }

    private void getWebsitesByCountryAndCategory(String country, String category,ListView listView) {
        WebsitesController.CallBack_Websites callBackWebsites = new WebsitesController.CallBack_Websites() {
            @Override
            public void success(List<WebsitesPerCategory> websitesPerCategory) {
                // Create an adapter with the list of websites
                WebsiteAdapter adapter = new WebsiteAdapter(WebsitesActivity.this, websitesPerCategory);
                // Set the adapter to the ListView
                listView.setAdapter(adapter);
            }

            @Override
            public void error(String error) {

            }
        };
        new WebsitesController(callBackWebsites).getWebsitesByCountryAndCategory(country, category);
    }
}

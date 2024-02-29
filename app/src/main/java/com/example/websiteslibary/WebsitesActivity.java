package com.example.websiteslibary;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mywebsites.WebsitesController;
import com.example.mywebsites.WebsitesPerCategory;

import java.util.List;

public class WebsitesActivity extends AppCompatActivity {

    private WebsitesController websitesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        // Retrieve data from intent
        String country = getIntent().getStringExtra("country");
        String category = getIntent().getStringExtra("category");
        // Get the ListView reference from the layout
        ListView listView = findViewById(R.id.listViewWebsites);

        // Show toast with country and category
        Toast.makeText(this, "Country: " + country + ", Category: " + category, Toast.LENGTH_SHORT).show();
        getWebsitesByCountryAndCategory(country, category,listView);
    }

        private void getWebsitesByCountryAndCategory(String country, String category,ListView listView) {
        WebsitesController.CallBack_Websites callBackWebsites = new WebsitesController.CallBack_Websites() {
            @Override
            public void success(List<WebsitesPerCategory> websitesPerCategory) {
                Log.d("pttt", "success: " + websitesPerCategory);
                Toast.makeText(WebsitesActivity.this, websitesPerCategory.toString(), Toast.LENGTH_SHORT).show();
                // Create an adapter with the list of websites
                WebsiteAdapter adapter = new WebsiteAdapter(WebsitesActivity.this, websitesPerCategory);

                // Set the adapter to the ListView
                listView.setAdapter(adapter);

            }

            @Override
            public void error(String error) {///

            }
        };
        new WebsitesController(callBackWebsites).getWebsitesByCountryAndCategory(country, category);
    }
}

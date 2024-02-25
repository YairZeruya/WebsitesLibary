package com.example.websiteslibary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mywebsites.WebsitesController;
import com.example.mywebsites.WebsitesPerCategory;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // Retrieve the country string from the intent
        String country = getIntent().getStringExtra("country");

        // Display the country string in a toast message
        Toast.makeText(this, country, Toast.LENGTH_SHORT).show();

        // Get references to buttons
        Button btnNews = findViewById(R.id.btnNews);
        Button btnEconomy = findViewById(R.id.btnEconomy);
        Button btnSports = findViewById(R.id.btnSports);

        // Set onClickListener for btnNews
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToWebsitesActivity(country, "news");
            }
        });

        btnEconomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToWebsitesActivity(country, "Economy");
            }
        });

        btnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToWebsitesActivity(country, "Sports");
            }
        });

        // Implement onClickListeners for other buttons if needed
    }

    private void getWebsitesByCountryAndCategory(String country, String category) {
        WebsitesController.CallBack_Websites callBackWebsites = new WebsitesController.CallBack_Websites() {
            @Override
            public void success(@NonNull List<WebsitesPerCategory> websitesPerCategory) {
                Log.d("pttt", "success: " + websitesPerCategory);
                Toast.makeText(CategoriesActivity.this, websitesPerCategory.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void error(String error) {///

            }
        };
        new WebsitesController(callBackWebsites).getWebsitesByCountryAndCategory(country, category);
    }


    // Method to move to WebsitesActivity and pass data via intent
    private void moveToWebsitesActivity(String country, String category) {
        Intent intent = new Intent(CategoriesActivity.this, WebsitesActivity.class);
        intent.putExtra("country", country);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}

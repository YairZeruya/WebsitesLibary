package com.example.websiteslibary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mywebsites.WebsitesController;
import com.example.mywebsites.WebsitesPerCategory;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    private Button btnNews;
    private Button btnEconomy;
    private Button btnSports;
    private TextView countryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        String country = getIntent().getStringExtra("country");
        Toast.makeText(this, "Country: " + country, Toast.LENGTH_SHORT).show();
        findViews();
        countryName.setText("Choose a category in " + country);
        setOnClickListeners(country);
    }

    private void setOnClickListeners(String country) {
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToWebsitesActivity(country, "news");
            }
        });

        btnEconomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToWebsitesActivity(country, "economy");
            }
        });

        btnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToWebsitesActivity(country, "sports");
            }
        });
    }

    private void findViews() {
        btnNews = findViewById(R.id.btnNews);
        btnEconomy = findViewById(R.id.btnEconomy);
        btnSports = findViewById(R.id.btnSports);
        countryName = findViewById(R.id.countryName);
    }

    private void moveToWebsitesActivity(String country, String category) {
        Intent intent = new Intent(CategoriesActivity.this, WebsitesActivity.class);
        intent.putExtra("country", country);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}

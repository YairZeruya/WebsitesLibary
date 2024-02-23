package com.example.websiteslibary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mywebsites.WebsitesController;
import com.example.mywebsites.WebsitesPerCategory;
import com.google.android.material.button.MaterialButton;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_getWebsites;
    private WebsitesController websitesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        websitesController = new WebsitesController();

        main_BTN_getWebsites = findViewById(R.id.mian_BTN_getWebsites);
        main_BTN_getWebsites.setOnClickListener(v -> getWebsitesForCountry("usa"));
    }

    private void getWebsitesForCountry(String country) {
        websitesController.getWebsitesByCountry(country, new Callback<Map<String, WebsitesPerCategory>>() {
            @Override
            public void onResponse(Call<Map<String, WebsitesPerCategory>> call, Response<Map<String, WebsitesPerCategory>> response) {
                if (response.isSuccessful()) {
                    Map<String, WebsitesPerCategory> websites = response.body();
                    // Handle received websites data here
                    Toast.makeText(MainActivity.this, "Websites received: " + websites.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("MainActivity", "Failed to get websites: " + response.code());
                    // Handle error here
                    Toast.makeText(MainActivity.this, "Failed to get websites: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Map<String, WebsitesPerCategory>> call, Throwable t) {
                Log.e("MainActivity", "Failed to get websites: " + t.getMessage());
                // Handle failure here
                Toast.makeText(MainActivity.this, "Failed to get websites: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

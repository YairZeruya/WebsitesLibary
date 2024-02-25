package com.example.websiteslibary;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.mywebsites.WebsitesController;
import com.example.mywebsites.WebsitesPerCategory;
import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnIsrael;
    private WebsitesController websitesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

       // websitesController = new WebsitesController();

        btnIsrael = findViewById(R.id.btnIsrael);
        btnIsrael.setOnClickListener(v -> MoveToCategoriesActivities("israel"));
        getWebsitesByCountryAndCategory("israel","news");
    }

    private void MoveToCategoriesActivities(String country) {
        // Create an intent to start CategoryActivity
        Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
        // Add the country as an extra to the intent
        intent.putExtra("country", country);
        // Start the activity
        startActivity(intent);
    }

        private void getWebsitesByCountryAndCategory(String country, String category) {
        WebsitesController.CallBack_Websites callBackWebsites = new WebsitesController.CallBack_Websites() {
            @Override
            public void success(@NonNull List<WebsitesPerCategory> websitesPerCategory) {
                Log.d("pttt", "success: " + websitesPerCategory);
                Toast.makeText(MainActivity.this, websitesPerCategory.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void error(String error) {///

            }
        };
        new WebsitesController(callBackWebsites).getWebsitesByCountryAndCategory(country, category);
    }



}

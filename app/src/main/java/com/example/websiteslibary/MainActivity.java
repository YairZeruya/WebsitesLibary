package com.example.websiteslibary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.mywebsites.Websites;
import com.example.mywebsites.WebsitesController;
import com.example.mywebsites.WebsitesPerCountry;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialButton main_BTN_getWebsites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int result = Websites.add(2,2);
        main_BTN_getWebsites = findViewById(R.id.mian_BTN_getWebsites);
        main_BTN_getWebsites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebsitesController websitesController = new WebsitesController(new WebsitesController.CallBack_Websites() {
                    @Override
                    public void success(WebsitesPerCountry websitesPerCountry) {
                        Log.d("pttt", "" + websitesPerCountry);
                    }

                    @Override
                    public void error(String error) {

                    }
                });
                websitesController.fetchAllWebsites("israel");
                Log.d("pttt", "d");
            }
        });
    }
}
package com.example.mywebsites;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebsitesController {

    private static final String BASE_URL = "http://192.168.1.218:8088/";
    private static final String TAG = "WebsiteController";

    private WebsitesAPI websitesAPI;

    public WebsitesController() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        websitesAPI = retrofit.create(WebsitesAPI.class);
    }

    public void getWebsitesByCountry(String country, Callback<Map<String, WebsitesPerCategory>> callback) {
        Call<Map<String, WebsitesPerCategory>> call = websitesAPI.getWebsitesByCountry(country);
        call.enqueue(callback);
    }
}

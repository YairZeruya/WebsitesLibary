package com.example.mywebsites;

import static com.google.android.material.color.utilities.MaterialDynamicColors.error;

import android.util.Log;
import android.widget.Toast;

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
    private WebsitesAPI websitesAPI;

    private CallBack_Websites callBackWebsites;


    public WebsitesController() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        websitesAPI = retrofit.create(WebsitesAPI.class);
    }

    public void getWebsitesByCountryAndCategory(String country, String category) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        websitesAPI = retrofit.create(WebsitesAPI.class);
        Call<WebsitesPerCategory> call = websitesAPI.getWebsitesByCountryAndCategory(country, category);
        call.enqueue(internalWebsitesCallBack);
    }

    private Callback<WebsitesPerCategory> internalWebsitesCallBack = new Callback<WebsitesPerCategory>() {
        @Override
        public void onResponse(Call<WebsitesPerCategory> call, Response<WebsitesPerCategory> response) {
            Log.d("pttt", "onResponse: " + response.body());
            WebsitesPerCategory websitesPerCategory = response.body();
            callBackWebsites.success(websitesPerCategory);
            int x = 0;
            }

        @Override
        public void onFailure(Call<WebsitesPerCategory> call, Throwable t) {
            callBackWebsites.error(t.getMessage());
            t.printStackTrace();
        }
    };

public interface CallBack_Websites {
    void success(WebsitesPerCategory websitesPerCategory);
    void error(String error);
}

}

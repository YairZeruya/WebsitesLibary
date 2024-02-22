package com.example.mywebsites;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebsitesController implements Callback<WebsitesPerCountry> {
    static final String BASE_URL = "http://192.168.1.218:8088";

    private CallBack_Websites callBackWebsites;


    public WebsitesController(CallBack_Websites callBackWebsites) {
        this.callBackWebsites = callBackWebsites;
    }

    public void fetchAllWebsites(String country) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WebsitesAPI websitesAPI = retrofit.create(WebsitesAPI.class);

        Call<WebsitesPerCountry> call = websitesAPI.loadWebsitesByCountry(country);
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<WebsitesPerCountry> call, Response<WebsitesPerCountry> response) {
        if (response.isSuccessful()) {
            WebsitesPerCountry websitesPerCountry = response.body();
            callBackWebsites.success(websitesPerCountry);
            int x = 0;
            Log.d("pttt", "" + response.body());

        } else {
            callBackWebsites.error("" + response.errorBody());
            Log.d("pttt", "" + response.errorBody());

        }
    }

    @Override
    public void onFailure(Call<WebsitesPerCountry> call, Throwable t) {
        callBackWebsites.error(t.getMessage());
        t.printStackTrace();
    }


    public interface CallBack_Websites {
        void success(WebsitesPerCountry websitesPerCountry);
        void error(String error);
    }

}

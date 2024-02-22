package com.example.mywebsites;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebsitesAPI {

    @GET("{country}")
    Call<WebsitesPerCountry> loadWebsitesByCountry(@Path("country") String country);

    @GET("country/category")
    Call<WebsitesPerCategory> loadWebsitesByCountryAndCategory();
}
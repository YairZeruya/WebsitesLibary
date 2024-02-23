package com.example.mywebsites;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebsitesAPI {

    @GET("/{country}")
    Call<Map<String, WebsitesPerCategory>> getWebsitesByCountry(@Path("country") String country);
}
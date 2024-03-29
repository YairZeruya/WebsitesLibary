package com.example.mywebsites;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface WebsitesAPI {
    @GET("/{country}/{category}")
    Call<List<String>> getWebsitesByCountryAndCategory(
            @Path("country") String country,
            @Path("category") String category
    );
}




package com.example.mywebsites;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebsitesController {
    private static final String BASE_URL = "http://192.168.1.218:8088/";
    private WebsitesAPI websitesAPI;
    private CallBack_Websites callBackWebsites;

    public WebsitesController(CallBack_Websites callBackWebsites) {
        this.callBackWebsites = callBackWebsites;
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
        Call<List<String>> call = websitesAPI.getWebsitesByCountryAndCategory(country, category);
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    List<String> urls = response.body();
                    List<WebsitesPerCategory> websitesPerCategoryList = new ArrayList<>();
                    for (String url : urls) {
                        WebsitesPerCategory websitesPerCategory = new WebsitesPerCategory();
                        websitesPerCategory.setUrl(url);
                        websitesPerCategoryList.add(websitesPerCategory);
                    }
                    callBackWebsites.success(websitesPerCategoryList);
                } else {
                    callBackWebsites.error("Failed to get websites: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                callBackWebsites.error("Failed to get websites: " + t.getMessage());
            }
        });
    }

    public interface CallBack_Websites {
        void success(List<WebsitesPerCategory> websitesPerCategory);

        void error(String error);
    }
}

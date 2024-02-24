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
        main_BTN_getWebsites.setOnClickListener(v -> getWebsitesByCountryAndCategory("usa", "economy"));
    }

    //{
    //  "economy": [
    //    "https://www.wsj.com/"
    //  ]
    //}


    private void getWebsitesByCountryAndCategory(String country, String category) {
        WebsitesController.CallBack_Websites callBackWebsites = new WebsitesController.CallBack_Websites() {
            @Override
            public void success(WebsitesPerCategory websitesPerCategory) {
                Log.d("pttt", "success: " + websitesPerCategory);
                Toast.makeText(MainActivity.this, websitesPerCategory.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void error(String error) {

            }
        };
        websitesController.getWebsitesByCountryAndCategory(country, category);
    }

}

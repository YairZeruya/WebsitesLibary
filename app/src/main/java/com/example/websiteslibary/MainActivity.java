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
    private ImageButton btnUSA;
    private ImageButton btnUK;
    private ImageButton btnFrance;
    private ImageButton btnGermany;
    private ImageButton btnItaly;
    private ImageButton btnSpain;
    private ImageButton btnCanada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        findviews();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        btnCanada.setOnClickListener(v -> MoveToCategoriesActivities("canada"));
        btnSpain.setOnClickListener(v -> MoveToCategoriesActivities("spain"));
        btnItaly.setOnClickListener(v -> MoveToCategoriesActivities("italy"));
        btnGermany.setOnClickListener(v -> MoveToCategoriesActivities("germany"));
        btnFrance.setOnClickListener(v -> MoveToCategoriesActivities("france"));
        btnUK.setOnClickListener(v -> MoveToCategoriesActivities("uk"));
        btnUSA.setOnClickListener(v -> MoveToCategoriesActivities("usa"));
        btnIsrael.setOnClickListener(v -> MoveToCategoriesActivities("israel"));
    }

    private void findviews() {
        btnIsrael = findViewById(R.id.btnIsrael);
        btnUSA = findViewById(R.id.btnUSA);
        btnUK = findViewById(R.id.btnUK);
        btnFrance = findViewById(R.id.btnFrance);
        btnGermany = findViewById(R.id.btnGermany);
        btnItaly = findViewById(R.id.btnItaly);
        btnSpain = findViewById(R.id.btnSpain);
        btnCanada = findViewById(R.id.btnCanada);
    }

    private void MoveToCategoriesActivities(String country) {
        Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
        intent.putExtra("country", country);
        startActivity(intent);
    }

}

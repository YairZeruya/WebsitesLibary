package com.example.websiteslibary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mywebsites.Websites;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int result = Websites.add(2,2);
    }
}
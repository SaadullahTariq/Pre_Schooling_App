package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        setTitle(getString(R.string.fruit_title));
    }
}
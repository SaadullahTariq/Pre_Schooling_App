package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BodyPartsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);
        setTitle(getString(R.string.bodypart_title));
    }
}
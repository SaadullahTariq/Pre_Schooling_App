package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UrduActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu);
        setTitle(getString(R.string.urdu_title));
    }
}
package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MonthsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
        setTitle(getString(R.string.month_title));
    }
}
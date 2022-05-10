package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        setTitle(getString(R.string.animal_title));
    }
}
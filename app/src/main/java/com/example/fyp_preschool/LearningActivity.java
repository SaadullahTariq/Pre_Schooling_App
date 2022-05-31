package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


public class LearningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView card_abc, card_animal, card_123, card_fruit, card_month, card_day, card_bodypart, card_shapes, card_prayer, card_urdu;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        setTitle(R.string.landing_title);

        card_abc = findViewById(R.id.card_abc);
        card_animal = findViewById(R.id.card_animal);
        card_123 = findViewById(R.id.card_123);
        card_fruit = findViewById(R.id.card_fruit);
        card_month = findViewById(R.id.card_month);
        card_day = findViewById(R.id.card_day);
        card_bodypart = findViewById(R.id.card_bodyPart);
        card_shapes = findViewById(R.id.card_shapes);
        card_prayer = findViewById(R.id.card_prayer);
        card_urdu = findViewById(R.id.card_urdu);

        card_abc.setOnClickListener(view -> startActivity(new Intent(LearningActivity.this, AlphabetsActivity.class)));
}
}
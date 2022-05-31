package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView quiz_card_abc, quiz_card_animal, quiz_card_fruit, quiz_card_bodypart, quiz_card_shapes, quiz_card_urdu;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz_card_abc = findViewById(R.id.quiz_card_abc);
        quiz_card_animal = findViewById(R.id.quiz_card_animal);
        quiz_card_fruit = findViewById(R.id.quiz_card_fruits);
        quiz_card_bodypart = findViewById(R.id.quiz_card_body_parts);
        quiz_card_shapes = findViewById(R.id.quiz_card_shape);
        quiz_card_urdu = findViewById(R.id.quiz_card_urdu);

        quiz_card_abc.setOnClickListener(view -> startActivity(new Intent(QuizActivity.this, QuizAlphabetsActivity.class)));


    }
}
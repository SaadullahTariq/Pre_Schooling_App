package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView leaningView, quizView, gameView, videolearningView, drawingView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        setTitle(getString(R.string.landing_title));
        leaningView = findViewById(R.id.learningView);
        quizView = findViewById(R.id.quizView);
        gameView = findViewById(R.id.gameView);
        videolearningView = findViewById(R.id.videolearningView);
        drawingView = findViewById(R.id.drawingView);

        leaningView.setOnClickListener(view -> startActivity(new Intent(LandingActivity.this, LearningActivity.class)));

        quizView.setOnClickListener(view -> startActivity(new Intent(LandingActivity.this, QuizActivity.class)));

        drawingView.setOnClickListener(view -> { startActivity(new Intent(LandingActivity.this, DrawingActivity.class));

        });


    }
}
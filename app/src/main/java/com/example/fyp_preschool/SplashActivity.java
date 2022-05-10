package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageview5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle(getString(R.string.splash_title));
        textView = findViewById(R.id.textView);
        imageview5 = findViewById(R.id.imageView5);
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.zoom1);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.zoom2);

        anim1.reset();
        textView.clearAnimation();
        textView.startAnimation(anim1);

        anim2.reset();
        imageview5.clearAnimation();
        imageview5.startAnimation(anim2);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LandingActivity.class));
                finish();
            }
        }, 3500);
    }
}
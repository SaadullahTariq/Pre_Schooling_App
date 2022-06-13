package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import java.util.ArrayList;

public class AlphabetsActivity extends AppCompatActivity {

    ArrayList<AlphabetItem>  alphabetItems = new ArrayList<>();
    CenterZoomLayoutManager centerZoomLayoutManager;

    Button previous, next, play;
    MediaPlayer mediaPlayer;
    int counter = 0;

    int[] alphabet_images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k,
            R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q,
            R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w,
            R.drawable.x, R.drawable.y, R.drawable.z,};

    int[] sound = {R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.h,
            R.raw.i, R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.o, R.raw.p, R.raw.q,
            R.raw.r, R.raw.s, R.raw.t, R.raw.u, R.raw.v, R.raw.w, R.raw.x, R.raw.y, R.raw.z};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        previous = findViewById(R.id.previous_btn);
        play = findViewById(R.id.play_btn);
        next = findViewById(R.id.next_btn);




        setAlphabetItems();

        Alphabet_Recyclerview adapter = new Alphabet_Recyclerview(this, alphabetItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        previous.setOnClickListener(view -> {
//            counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
            if(counter != 0){
                counter--;
            }
            recyclerView.smoothScrollToPosition(counter);
        });

        next.setOnClickListener(view -> {
//            counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
            if(counter != 25){
                counter++;
            }
            recyclerView.smoothScrollToPosition(counter);
        });

        recyclerView.scrollToPosition(counter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

         play.setOnClickListener(view -> {
//            counter = centerZoomLayoutManager.findLastCompletelyVisibleItemPosition();
            if(mediaPlayer !=null) {
                mediaPlayer.release();
            }
            mediaPlayer = MediaPlayer.create(getApplicationContext(), sound[counter]);
            mediaPlayer.start();
        });
    }

    private void setAlphabetItems(){
        String[] alphabet_word = getResources().getStringArray(R.array.words);

        for (int i = 0 ; i < alphabet_word.length; i++){
            alphabetItems.add(new AlphabetItem(alphabet_word[i],
                    alphabet_images[i]));
        }
    }

}
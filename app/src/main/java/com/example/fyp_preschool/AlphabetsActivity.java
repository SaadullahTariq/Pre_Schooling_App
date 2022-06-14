package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;


import java.util.ArrayList;
import java.util.Locale;

public class AlphabetsActivity extends AppCompatActivity {

    ArrayList<AlphabetItem>  alphabetItems = new ArrayList<>();

    Button previous, next, play;
    int counter = 0;
    TextToSpeech textToSpeech;
    int whichOne;

    int[] alphabet_images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k,
            R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q,
            R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w,
            R.drawable.x, R.drawable.y, R.drawable.z};

    int [] counting_images = {R.drawable.one_1, R.drawable.two_2, R.drawable.three_3, R.drawable.four_4,
            R.drawable.five_5, R.drawable.six_6, R.drawable.seven_7, R.drawable.eight_8, R.drawable.nine_9,
            R.drawable.ten_10, R.drawable.eleven_11, R.drawable.twelve_12, R.drawable.thirteen_13, R.drawable.fourteen_14,
            R.drawable.fifteen_15, R.drawable.sixteen_16, R.drawable.seventeen_17, R.drawable.eighteen_18, R.drawable.nineteen_19, R.drawable.twenty_20};

    int [] colors_images = {R.drawable.green, R.drawable.pink, R.drawable.red, R.drawable.black,
            R.drawable.aqua, R.drawable.blue, R.drawable.brown, R.drawable.slate, R.drawable.violet, R.drawable.white, R.drawable.yellow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        previous = findViewById(R.id.previous_btn);
        play = findViewById(R.id.play_btn);
        next = findViewById(R.id.next_btn);
        textToSpeech = new TextToSpeech(this, i -> {
            if (i!= TextToSpeech.ERROR){
                textToSpeech.setLanguage(Locale.ENGLISH);
            }
        });

        whichOne = getIntent().getIntExtra("whichOne", 0);
        if (whichOne == 1){
            setAlphabetItems();
        }
        else if (whichOne == 2){
            setCountingItems();
        }
        else if (whichOne == 6){
            setColorItems();
        }

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
             if (whichOne == 1){
                 String[] alphabets = getResources().getStringArray(R.array.words);
                 textToSpeech.speak(alphabets[counter], TextToSpeech.QUEUE_FLUSH, null);
             }
             else if (whichOne == 2){
                 String[] counting = getResources().getStringArray(R.array.count);
                 textToSpeech.speak(counting[counter], TextToSpeech.QUEUE_FLUSH, null);
             }
             else if (whichOne == 6){
                 String[] colors = getResources().getStringArray(R.array.colors);
                 textToSpeech.speak(colors[counter], TextToSpeech.QUEUE_FLUSH, null);
             }
         });
    }

    private void setAlphabetItems(){
        String[] alphabets = getResources().getStringArray(R.array.words);
        for (int i = 0 ; i < alphabets.length; i++){
            alphabetItems.add(new AlphabetItem(alphabets[i].substring(alphabets[i].lastIndexOf(" ") + 1),
                    alphabet_images[i]));
        }
    }

    private void setCountingItems(){
        String[] counting = getResources().getStringArray(R.array.count);
        for (int i = 0 ; i < counting.length; i++){
            alphabetItems.add(new AlphabetItem(counting[i],
                    counting_images[i]));
        }
    }

    private void setColorItems(){
        String[] colors = getResources().getStringArray(R.array.colors);

        for (int i = 0 ; i < colors.length; i++){
            alphabetItems.add(new AlphabetItem(colors[i],
                    colors_images[i]));
        }
    }

}
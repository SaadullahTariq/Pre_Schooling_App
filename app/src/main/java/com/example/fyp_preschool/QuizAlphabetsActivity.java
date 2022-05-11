package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class QuizAlphabetsActivity extends AppCompatActivity {

    TextView questionNumberTV;
    ImageView questionTV;
    Button option1Btn, option2Btn, option3Btn, option4Btn;
    ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentscore = 0, questionAttempted = 1, currentPos;

    int[] alphabet_images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k,
            R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q,
            R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w,
            R.drawable.x, R.drawable.y, R.drawable.z,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_alphabets);
        questionTV = findViewById(R.id.TVQUESTION);
        questionNumberTV = findViewById(R.id.TVQUESTIONATTEMPTED);
        option1Btn = findViewById(R.id.BtnOption1);
        option2Btn = findViewById(R.id.BtnOption2);
        option3Btn = findViewById(R.id.BtnOption3);
        option4Btn = findViewById(R.id.BtnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(view -> {
            if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                currentscore++;
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModelArrayList.size());
            setDataToViews(currentPos);
        });

        option2Btn.setOnClickListener(view -> {
            if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                currentscore++;
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModelArrayList.size());
            setDataToViews(currentPos);
        });

        option3Btn.setOnClickListener(view -> {
            if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                currentscore++;
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModelArrayList.size());
            setDataToViews(currentPos);
        });

        option4Btn.setOnClickListener(view -> {
            if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                currentscore++;
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModelArrayList.size());
            setDataToViews(currentPos);
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(QuizAlphabetsActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, findViewById(R.id.showIDLinearLayout));
        TextView scoreTV = bottomSheetView.findViewById(R.id.TVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.BtnRestart);
        scoreTV.setText("Your score is \n" + currentscore + " / 10");

        restartQuizBtn.setOnClickListener(view -> {
            currentPos = random.nextInt(quizModelArrayList.size());
            setDataToViews(currentPos);
            questionAttempted = 1;
            currentscore = 0;
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void setDataToViews(int currentPos) {
        questionNumberTV.setText("Questions Attempted : " + questionAttempted + " /10");

        if(questionAttempted == 11) {
            showBottomSheet();
        }else{
            questionTV.setImageResource(quizModelArrayList.get(currentPos).getImage());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel(alphabet_images[0], "Apple", "Banana", "Cat", "Dog", "Apple"));
        quizModelArrayList.add(new QuizModel(alphabet_images[1], "Banana", "Zebra", "Cat", "Fish", "Banana"));
        quizModelArrayList.add(new QuizModel(alphabet_images[2], "Parrot", "YAk", "Apple", "Cat", "Cat"));
        quizModelArrayList.add(new QuizModel(alphabet_images[3], "Parrot", "Dog", "House", "Umbrella", "Dog"));
        quizModelArrayList.add(new QuizModel(alphabet_images[4], "Apple", "Zebra", "Yak", "Elephant", "Elephant"));
        quizModelArrayList.add(new QuizModel(alphabet_images[5], "Fish", "Banana", "Watch", "Violin", "Fish"));
        quizModelArrayList.add(new QuizModel(alphabet_images[6], "Train", "Sun", "Gate", "Dog", "Gate"));
        quizModelArrayList.add(new QuizModel(alphabet_images[7], "Sun", "Banana", "Zebra", "House", "House"));
        quizModelArrayList.add(new QuizModel(alphabet_images[8], "Ink Pot", "Cat", "Xylophone", "Queen", "Ink Pot"));
        quizModelArrayList.add(new QuizModel(alphabet_images[9], "Nose", "Banana", "Jacket", "Lemon", "Jacket"));
        quizModelArrayList.add(new QuizModel(alphabet_images[10], "Kite", "Orange", "Cat", "Watch", "Kite"));
        quizModelArrayList.add(new QuizModel(alphabet_images[11], "Banana", "Sun", "Lemon", "Parrot", "Lemon"));
        quizModelArrayList.add(new QuizModel(alphabet_images[12], "Apple", "Monkey", "Elephant", "Cat", "Monkey"));
        quizModelArrayList.add(new QuizModel(alphabet_images[13], "Queen", "Banana", "Orange", "Nose", "Nose"));
        quizModelArrayList.add(new QuizModel(alphabet_images[14], "Orange", "Banana", "Dog", "Gate", "Orange"));
        quizModelArrayList.add(new QuizModel(alphabet_images[15], "Sun", "Cat", "Parrot", "Dog", "Parrot"));
        quizModelArrayList.add(new QuizModel(alphabet_images[16], "Apple", "Queen", "Train", "Yak", "Queen"));
        quizModelArrayList.add(new QuizModel(alphabet_images[17], "Zebra", "Monkey", "Rabbit", "Dog", "Rabbit"));
        quizModelArrayList.add(new QuizModel(alphabet_images[18], "Watch", "Sun", "Violin", "Gate", "Sun"));
        quizModelArrayList.add(new QuizModel(alphabet_images[19], "Apple", "Watch", "Cat", "Train", "Train"));
        quizModelArrayList.add(new QuizModel(alphabet_images[20], "Apple", "Umbrella", "Gate", "Yak", "Umbrella"));
        quizModelArrayList.add(new QuizModel(alphabet_images[21], "Xylophone", "Apple", "Dog", "Violin", "Violin"));
        quizModelArrayList.add(new QuizModel(alphabet_images[22], "Yak", "Watch", "House", "Ink Pot", "Watch"));
        quizModelArrayList.add(new QuizModel(alphabet_images[23], "Zebra", "Banana", "Xylophone", "Jacket", "Xylophone"));
        quizModelArrayList.add(new QuizModel(alphabet_images[24], "Kite", "Cat", "Yak", "Dog", "Yak"));
        quizModelArrayList.add(new QuizModel(alphabet_images[25], "Monkey", "Lemon", "Dog", "Zebra", "Zebra"));

    }
}
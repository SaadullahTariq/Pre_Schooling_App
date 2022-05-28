package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToe extends AppCompatActivity {
    Button playAgainBtn, homeBtn;
    TextView playerTurn;
    private TicTacToeBoard ticTacToeBoard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);

        playAgainBtn = findViewById(R.id.playerAgainBtn);
        homeBtn = findViewById(R.id.homeBtn);
        playerTurn = findViewById(R.id.playerDisplay);
        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAME");

        if (playerNames != null){
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }
        ticTacToeBoard.setUpGame(playAgainBtn, homeBtn, playerTurn, playerNames);

        homeBtn.setOnClickListener(view -> {
            Intent intent = new Intent(TicTacToe.this, LandingActivity.class);
            startActivity(intent);
        });
        playAgainBtn.setOnClickListener(view -> {
            ticTacToeBoard.resetGame();
            ticTacToeBoard.invalidate();
        });

    }
}
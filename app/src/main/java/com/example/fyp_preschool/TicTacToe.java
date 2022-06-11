package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class TicTacToe extends AppCompatActivity {
    Button playAgainBtn, homeBtn;
    TextView playerTurn;
    KonfettiView konfettiView;
    private TicTacToeBoard ticTacToeBoard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);

        playAgainBtn = findViewById(R.id.playerAgainBtn);
        homeBtn = findViewById(R.id.homeBtn);
        playerTurn = findViewById(R.id.playerDisplay);
        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);
        konfettiView = findViewById(R.id.konfettiView);

        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAME");

        if (playerNames != null){
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }
        ticTacToeBoard.setUpGame(playAgainBtn, homeBtn, playerTurn, playerNames, konfettiView);

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
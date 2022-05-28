package com.example.fyp_preschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class GameActivity extends AppCompatActivity {
    Button submit_btn;
    EditText player1, player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        submit_btn = findViewById(R.id.submit_button);
        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);

        submit_btn.setOnClickListener(view -> {
            String player1Name = player1.getText().toString();
            String player2Name = player2.getText().toString();

            Intent intent = new Intent(GameActivity.this, TicTacToe.class);
            intent.putExtra("PLAYER_NAME", new String[] {player1Name, player2Name});
            startActivity(intent);
        });

    }
}
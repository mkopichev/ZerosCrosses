package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TicTacToeGame ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        int[] gameButtonIds = new int[] {
                R.id.button1,
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8,
                R.id.button9,
                R.id.try_again_button
        };

        int[] specialViewIds = new int[] {
                R.id.header,
                R.id.x_win_counter,
                R.id.o_win_counter
        };

        ticTacToe = new TicTacToeGame();

        View.OnClickListener gameBoxesClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ticTacToe.gameBoxPressed(view.getId());
            }
        };

        for (int i = 0; i < gameButtonIds.length; i++) {
            findViewById(gameButtonIds[i]).setOnClickListener(gameBoxesClickListener);
        }

        for (int i = 0; i < specialViewIds.length; i++) {
            findViewById(specialViewIds[i]);
        }

    }

}
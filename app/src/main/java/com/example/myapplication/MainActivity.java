package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView title;
    Button b11;
    Button b12;
    Button b13;
    Button b21;
    Button b22;
    Button b23;
    Button b31;
    Button b32;
    Button b33;
    Button again_button;
    TextView x_no_of_wins;
    TextView o_no_of_wins;

    ZerosCrosses game = new ZerosCrosses();

    int moveNumber = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        title = findViewById(R.id.textView);
        b11 = findViewById(R.id.button1);
        b12 = findViewById(R.id.button2);
        b13 = findViewById(R.id.button3);
        b21 = findViewById(R.id.button4);
        b22 = findViewById(R.id.button5);
        b23 = findViewById(R.id.button6);
        b31 = findViewById(R.id.button7);
        b32 = findViewById(R.id.button8);
        b33 = findViewById(R.id.button9);
        again_button = findViewById(R.id.try_again_button);
        x_no_of_wins = findViewById(R.id.x_win_counter);
        o_no_of_wins = findViewById(R.id.o_win_counter);

        x_no_of_wins.setText("0");
        o_no_of_wins.setText("0");

        startAgain();
    }

    void enableGameButtons() {
        b11.setOnClickListener(btnPressed);
        b12.setOnClickListener(btnPressed);
        b13.setOnClickListener(btnPressed);
        b21.setOnClickListener(btnPressed);
        b22.setOnClickListener(btnPressed);
        b23.setOnClickListener(btnPressed);
        b31.setOnClickListener(btnPressed);
        b32.setOnClickListener(btnPressed);
        b33.setOnClickListener(btnPressed);
    }

    void disableGameButtons() {
        b11.setOnClickListener(null);
        b12.setOnClickListener(null);
        b13.setOnClickListener(null);
        b21.setOnClickListener(null);
        b22.setOnClickListener(null);
        b23.setOnClickListener(null);
        b31.setOnClickListener(null);
        b32.setOnClickListener(null);
        b33.setOnClickListener(null);
    }

    void startAgain() {
        title.setText(R.string.x_string);

        b11.setText("");
        b12.setText("");
        b13.setText("");
        b21.setText("");
        b22.setText("");
        b23.setText("");
        b31.setText("");
        b32.setText("");
        b33.setText("");

        enableGameButtons();

        again_button.setOnClickListener(againPressed);
        again_button.setVisibility(View.INVISIBLE);

        moveNumber = 0;
    }

    int checkEndGame(int moveNumber) {
        if ((moveNumber > 3) & (moveNumber < 10)) {
            //strings check
            if ((b11.getText().toString().equals(b12.getText().toString())) & (b11.getText().toString().equals(b13.getText().toString()))) {
                if (b11.getText().equals("X")) {
                    title.setText(R.string.x_winner);
                    return 1; //there is a winner
                } else if (b11.getText().equals("O")) {
                    title.setText(R.string.o_winner);
                    return 1; //there is a winner
                }
            }
            if ((b21.getText().toString().equals(b22.getText().toString())) & (b21.getText().toString().equals(b23.getText().toString()))) {
                if (b21.getText().equals("X")) {
                    title.setText(R.string.x_winner);
                    return 1; //there is a winner
                } else if (b21.getText().equals("O")) {
                    title.setText(R.string.o_winner);
                    return 1; //there is a winner
                }
            }
            if ((b31.getText().toString().equals(b32.getText().toString())) & (b31.getText().toString().equals(b33.getText().toString()))) {
                if (b31.getText().equals("X")) {
                    title.setText(R.string.x_winner);
                    return 1; //there is a winner
                } else if (b31.getText().equals("O")) {
                    title.setText(R.string.o_winner);
                    return 1; //there is a winner
                }
            }
            //columns check
            if ((b11.getText().toString().equals(b21.getText().toString())) & (b11.getText().toString().equals(b31.getText().toString()))) {
                if (b11.getText().equals("X")) {
                    title.setText(R.string.x_winner);
                    return 1; //there is a winner
                } else if (b11.getText().equals("O")) {
                    title.setText(R.string.o_winner);
                    return 1; //there is a winner
                }
            }
            if ((b12.getText().toString().equals(b22.getText().toString())) & (b12.getText().toString().equals(b32.getText().toString()))) {
                if (b12.getText().equals("X")) {
                    title.setText(R.string.x_winner);
                    return 1; //there is a winner
                } else if (b12.getText().equals("O")) {
                    title.setText(R.string.o_winner);
                    return 1; //there is a winner
                }
            }
            if ((b13.getText().toString().equals(b23.getText().toString())) & (b13.getText().toString().equals(b33.getText().toString()))) {
                if (b13.getText().equals("X")) {
                    title.setText(R.string.x_winner);
                    return 1; //there is a winner
                } else if (b13.getText().equals("O")) {
                    title.setText(R.string.o_winner);
                    return 1; //there is a winner
                }
            }
            //diagonals check
            if ((b11.getText().toString().equals(b22.getText().toString())) & (b11.getText().toString().equals(b33.getText().toString()))) {
                if (b11.getText().equals("X")) {
                    title.setText(R.string.x_winner);
                    return 1; //there is a winner
                } else if (b11.getText().equals("O")) {
                    title.setText(R.string.o_winner);
                    return 1; //there is a winner
                }
            }
            if ((b13.getText().toString().equals(b22.getText().toString())) & (b13.getText().toString().equals(b31.getText().toString()))) {
                if (b13.getText().equals("X")) {
                    title.setText(R.string.x_winner);
                    return 1; //there is a winner
                } else if (b13.getText().equals("O")) {
                    title.setText(R.string.o_winner);
                    return 1; //there is a winner
                }
            }
        }
        if (moveNumber >= 9) {
            title.setText(R.string.no_winner);
            return 2; //parity
        }
        return 0; // no winner
    }

    private final View.OnClickListener againPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startAgain();
        }
    };

    private final View.OnClickListener btnPressed = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {
            if (v instanceof Button) {

                Button btn = (Button) v;

                if (!(btn.getText().toString().equals(""))) {
                    return;
                }

                if (title.getText().equals("Turn of X")) {
                    btn.setText("X");
                    title.setText(R.string.o_string);
                } else {
                    btn.setText("O");
                    title.setText(R.string.x_string);
                }

                int result = checkEndGame(++moveNumber);

                if ((result == 1) | (result == 2)) {
                    again_button.setVisibility(View.VISIBLE);
                    disableGameButtons();

                    if (title.getText().equals("X is the winner!"))
                        x_no_of_wins.setText("" + 1);
                    else if (title.getText().equals("O is the winner!"))
                        o_no_of_wins.setText("" + 1);
                }
            }
        }
    };
}

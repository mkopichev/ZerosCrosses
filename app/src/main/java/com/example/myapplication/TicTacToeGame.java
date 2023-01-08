package com.example.myapplication;

public class TicTacToeGame {

    private final int[][] gameState = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}};

    private final int[][] winSeries = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}};

    public void gameBoxPressed(int gameButtonId) {

    }

    public void specialView(int specialViewId) {

    }

    public int ifSomeoneWin() {

        return 0;
    }

}

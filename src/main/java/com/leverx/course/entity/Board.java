package com.leverx.course.entity;

import java.util.List;

public class Board {

    private char[][] board;

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }


    public boolean isValidMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        return move >= 1 && move <= 9 && board[row][col] == ' ';
    }

    public boolean isFull() {

    }

    public boolean makeMove() {

    }

    public char checkWinner() {

    }

    public List<Integer> getAvailableMoves() {

    }
}

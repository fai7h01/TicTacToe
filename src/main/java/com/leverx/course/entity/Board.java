package com.leverx.course.entity;

import com.leverx.course.enums.Sign;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private char[][] board;

    public Board() {
        board = new char[3][3];
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
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeMove(int move, Sign sign) {
        if (isValidMove(move)) {
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            board[row][col] = sign.getChar();
        }
    }

    //returns winner's sign
    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }

            if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return board[0][0];
            }

            if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return board[0][2];
            }
        }
        return ' ';
    }

    //returns available positions
    public List<Integer> getAvailableMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    int cellNumber = i * 3 + j + 1;
                    moves.add(cellNumber);
                }
            }
        }
        return moves;
    }

    public void printBoard() {
        System.out.printf("""
                         %c | %c | %c
                        ---|---|---
                         %c | %c | %c
                        ---|---|---
                         %c | %c | %c
                        %n""",
                board[0][0], board[0][1], board[0][2],
                board[1][0], board[1][1], board[1][2],
                board[2][0], board[2][1], board[2][2]);
    }

    public void printInstructionBoard() {
        System.out.println("""
            Welcome to Tic-Tac-Toe!

            Here's how the board looks:

            | - | - | - |
            | 1 | 2 | 3 |
            | - | - | - |
            | 4 | 5 | 6 |
            | - | - | - |
            | 7 | 8 | 9 |
            | - | - | - |

            Each number corresponds to a position on the board.
            You can make a move by choosing a number from 1 to 9.
            """);
    }

    public void resetBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}

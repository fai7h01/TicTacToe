package com.leverx.course.entity;

import com.leverx.course.enums.Difficulty;
import com.leverx.course.enums.Sign;

import java.util.List;
import java.util.Random;

public class Computer extends Player{

    private Difficulty difficulty;

    public Computer(Sign sign, Difficulty difficulty) {
        super(sign);
        this.difficulty = difficulty;
    }

    @Override
    public int getMove(Board board) {
        if (this.difficulty.equals(Difficulty.EASY)) {
            return getRandomMove(board);
        }
        return getBestMove(board);
    }

    private int getRandomMove(Board board) {
        List<Integer> availableMoves = board.getAvailableMoves();
        return availableMoves.get(new Random().nextInt(availableMoves.size()));
    }

    private int getBestMove(Board board) {

        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        List<Integer> availableMoves = board.getAvailableMoves();

        for (Integer move : availableMoves) {
            Board tempBoard = new Board();
            copyBoard(board.getBoard(), tempBoard.getBoard());
            tempBoard.makeMove(move, getSign());

            int score = miniMax(tempBoard, false); // after move, this checks possible outcomes (program is maximizer, user is minimizer)
            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private int miniMax(Board board, boolean isMaximizing) {
        char winner = board.checkWinner();
        if (winner == getSign().getChar()) return 1; // computer wins
        if (winner != getSign().getChar() && winner != ' ') return -1; // computer loses
        if (board.isFull()) return 0; // draw

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (Integer move : board.getAvailableMoves()) {
            Board tempBoard = new Board();
            copyBoard(board.getBoard(), tempBoard.getBoard());
            tempBoard.makeMove(move, isMaximizing ? getSign() : (getSign() == Sign.X ? Sign.O : Sign.X));
            int score = miniMax(tempBoard, !isMaximizing);
            bestScore = isMaximizing ? Math.max(score, bestScore) : Math.min(score, bestScore);
        }
        return bestScore;
    }

    private void copyBoard(char[][] board, char[][] copy) {
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, 3);
        }
    }
}


package com.leverx.course.entity;

import com.leverx.course.enums.Difficulty;
import com.leverx.course.enums.Sign;

import java.util.ArrayList;
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

    private int getBestMove(Board board) {
        return 0;
    }

    private int getRandomMove(Board board) {
        List<Integer> availableMoves = board.getAvailableMoves();
        return availableMoves.get(new Random().nextInt(availableMoves.size()));
    }
}

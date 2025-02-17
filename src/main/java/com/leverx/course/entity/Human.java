package com.leverx.course.entity;

import com.leverx.course.enums.Sign;

import java.util.Scanner;

public class Human extends Player{

    public Human(Sign sign) {
        super(sign);
    }

    @Override
    public int getMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int move;
        do {
            System.out.println("Enter your move [1-9]: ");
            if (scanner.hasNextInt()) {
                System.out.println("Invalid Move! Try again.");
                scanner.next();
            }
            move = scanner.nextInt();
        } while (!board.isValidMove(move));
        scanner.close();
        return move;
    }
}

package com.leverx.course.entity;

import com.leverx.course.enums.Difficulty;
import com.leverx.course.enums.Sign;

import java.util.Scanner;

public class Game {

    private Board board;
    private Player playerOne;
    private Player playerTwo;

    public Game() {
        this.board = new Board();
    }

    public void start(Scanner scanner) {

        board.printInstructionBoard();

        System.out.print("""
                Choose game mode by typing either 1 or 2:
                1. Player vs Player
                2. Player vs Computer
                """);

        int mode = scanner.nextInt();
        scanner.nextLine();


        if (mode == 1) {
            playerOne = new Human(Sign.X);
            playerTwo = new Human(Sign.O);
        } else {
            System.out.println("""
                    \nChoose game difficulty level typing either 1 or 2:
                    1. Easy
                    2. Hard
                    """);
            Difficulty difficulty = scanner.nextInt() == 1 ? Difficulty.EASY : Difficulty.HARD;
            playerOne = new Human(Sign.X);
            playerTwo = new Computer(Sign.O, difficulty);
        }

        play();
        scanner.nextLine();
        restartGame(scanner);
    }

    private void restartGame(Scanner scanner) {
        String answer;
        while (true) {
            System.out.println("Would you like to play again? (y/n)");
            answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("y")) {
                board.resetBoard();
                start(scanner);
                return;
            } else if (answer.equals("n")) {
                System.exit(0);
            } else {
                System.out.println("Invalid input! Please enter 'y' or 'n'.");
            }
        }
    }

    private void play() {
        boolean isGameOver = false;
        Player currentPlayer = playerOne;

        while (!isGameOver) {
            board.printBoard();

            if (currentPlayer instanceof Computer) {
                int move = currentPlayer.getMove(board);
                board.makeMove(move, currentPlayer.getSign());
            } else {
                System.out.println("Player " + currentPlayer.getSign() + "'s turn.");
                int move = currentPlayer.getMove(board);
                if (board.isValidMove(move)) {
                    board.makeMove(move, currentPlayer.getSign());
                } else {
                    System.out.println("Invalid move, try again.");
                    continue;
                }
            }

            char winner = board.checkWinner();
            if (winner != ' ') {
                board.printBoard();
                System.out.println("Player " + winner + " wins!");
                isGameOver = true;
            } else if (board.isFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                isGameOver = true;
            } else {
                currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
            }

        }
    }

}

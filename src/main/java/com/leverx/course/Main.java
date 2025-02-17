package com.leverx.course;

import com.leverx.course.entity.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        game.start(scanner);

    }
}
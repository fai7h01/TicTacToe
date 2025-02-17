package com.leverx.course.entity;

import com.leverx.course.enums.Sign;

import java.util.Scanner;

public abstract class Player {

    private Sign sign;

    public Player(Sign sign) {
        this.sign = sign;
    }

    public abstract int getMove(Board board, Scanner scanner);

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }
}

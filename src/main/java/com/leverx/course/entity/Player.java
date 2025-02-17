package com.leverx.course.entity;

import com.leverx.course.enums.Sign;


public abstract class Player {

    private Sign sign;

    public Player(Sign sign) {
        this.sign = sign;
    }

    public abstract int getMove(Board board);

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }
}

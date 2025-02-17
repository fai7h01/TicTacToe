package com.leverx.course.enums;

public enum Sign {

    X('X'), O('O');

    private char sign;

    Sign(char sign) {
        this.sign = sign;
    }

    public char getChar() {
        return sign;
    }
}

package com.leverx.course.enums;

public enum Difficulty {

    EASY("easy"), HARD("hard");

    private final String difficultyLevel;

    Difficulty(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

}

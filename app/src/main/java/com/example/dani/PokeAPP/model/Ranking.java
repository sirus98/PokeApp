package com.example.dani.PokeAPP.model;

public class Ranking {
    public static int score;
    String name;

    public Ranking(){}

    public Ranking(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

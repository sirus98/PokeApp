package com.example.dani.dgonzalezapp.model;

import io.realm.RealmObject;

public class Ranking {
    int score;
    String name;

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

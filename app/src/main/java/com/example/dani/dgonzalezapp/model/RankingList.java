package com.example.dani.dgonzalezapp.model;

import java.util.ArrayList;
import java.util.List;

public class RankingList {

    List<Ranking> rankings = new ArrayList<>();

    public void addRanking(Ranking ranking){

        rankings.add(ranking);

        ordenarRanking();

    }

    private void ordenarRanking() {

    }

    public List<Ranking> mostrarRanking(){

        return rankings;
    }
}

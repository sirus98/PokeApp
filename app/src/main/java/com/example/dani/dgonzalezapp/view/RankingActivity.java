package com.example.dani.dgonzalezapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.model.Ranking;
import com.example.dani.dgonzalezapp.model.RankingList;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        List<Ranking> rankings = new ArrayList<>();

        TextView pos1,pos2,pos3,pos4,pos5;


        rankings = new RankingList().mostrarRanking();

        pos1 = findViewById(R.id.pos1);
        pos2 = findViewById(R.id.pos2);
        pos3 = findViewById(R.id.pos3);
        pos4 = findViewById(R.id.pos4);
        pos5 = findViewById(R.id.pos5);

        pos1.setText(rankings.get(0).toString());
        pos2.setText(rankings.get(1).toString());
        pos3.setText(rankings.get(2).toString());
        pos4.setText(rankings.get(3).toString());
        pos5.setText(rankings.get(4).toString());


    }
}

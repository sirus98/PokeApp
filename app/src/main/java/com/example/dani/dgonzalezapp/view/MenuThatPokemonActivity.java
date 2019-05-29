package com.example.dani.dgonzalezapp.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.model.Ranking;

import java.util.ArrayList;
import java.util.List;

public class MenuThatPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_that_pokemon);

        boolean gmail = getIntent().getBooleanExtra("gmail", false);

        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuThatPokemonActivity.this, GamePokemonActivity.class);
                startActivity(intent);
            }
        });
        //TODO: Cambiar activity de destino.
        findViewById(R.id.btn_ranking).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gmail){
                    Intent intent =  new Intent(MenuThatPokemonActivity.this, RankingActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MenuThatPokemonActivity.this, "No esta disponible sin Gmail", Toast.LENGTH_SHORT).show();
                }


            }
        });
        //TODO: Cambiar activity de destino.
        findViewById(R.id.btn_tutorial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuThatPokemonActivity.this, MenuThatPokemonActivity.class);
                startActivity(intent);
            }
        });





        final ImageView gastly = findViewById(R.id.gastly);

        @SuppressLint("ResourceType") final ConstraintLayout layout = findViewById(R.layout.activity_menu_that_pokemon);

        Glide.with(this)
                .asGif()
                .load(R.raw.gastly)
                .into(gastly);
    }
}

package com.example.dani.dgonzalezapp.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dani.dgonzalezapp.MenuActivity;
import com.example.dani.dgonzalezapp.R;

public class Menu_that_pokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_that_pokemon);

        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Menu_that_pokemon.this, Game_pokemon.class);
                startActivity(intent);
            }
        });
        //TODO: Cambiar activity de destino.
        findViewById(R.id.btn_ranking).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Menu_that_pokemon.this, Menu_that_pokemon.class);
                startActivity(intent);
            }
        });
        //TODO: Cambiar activity de destino.
        findViewById(R.id.btn_tutorial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Menu_that_pokemon.this, Menu_that_pokemon.class);
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

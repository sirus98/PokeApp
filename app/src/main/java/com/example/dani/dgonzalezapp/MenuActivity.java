package com.example.dani.dgonzalezapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dani.dgonzalezapp.view.MainActivity;
import com.example.dani.dgonzalezapp.view.Menu_that_pokemon;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.ListaPokemon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuActivity.this, MainActivity.class);
                intent.putExtra("equipo", false);
                startActivity(intent);
            }
        });


        findViewById(R.id.Thatpokemon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuActivity.this, Menu_that_pokemon.class);
                intent.putExtra("who's that pokemon", false);
                startActivity(intent);
            }
        });


        findViewById(R.id.AdministrarEquipos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuActivity.this, EquiposActivity.class);
                startActivity(intent);
            }
        });

        final ImageView valor = findViewById(R.id.valor);

        @SuppressLint("ResourceType") final ConstraintLayout layout = findViewById(R.layout.activity_start_activity);

        Glide.with(this)
                .asGif()
                .load(R.raw.truevalor)
                .into(valor);





    }
}

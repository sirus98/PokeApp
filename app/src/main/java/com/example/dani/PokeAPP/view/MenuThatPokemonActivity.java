package com.example.dani.PokeAPP.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.dani.PokeAPP.R;

import mehdi.sakout.fancybuttons.FancyButton;


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

        findViewById(R.id.btn_tutorial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuThatPokemonActivity.this, MenuThatPokemonActivity.class);
                startActivity(intent);
            }
        });

        FancyButton btnInicio = findViewById(R.id.menu);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuThatPokemonActivity.this,MenuActivity.class);
                Boolean gmail = true;
                intent.putExtra("gmail", gmail);
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

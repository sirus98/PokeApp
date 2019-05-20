package com.example.dani.dgonzalezapp.view;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.model.PokeImages;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class Game_pokemon extends AppCompatActivity {
    List<PokeImages> pokeImages = new ArrayList<>();


    ImageView black;
    int random;
    EditText nombrePoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_pokemon);


        Random rand = new Random();
        black = findViewById(R.id.imagePoke);
        nombrePoke =findViewById(R.id.textPoke);
        try {
            pokeImages.add(new PokeImages("Dragonite",R.raw.b_dragonite,R.raw.dragonite));
            pokeImages.add(new PokeImages("Snorlax",R.raw.b_snorlax,R.raw.snorlax));
            pokeImages.add(new PokeImages("Manectric",R.raw.b_manectric,R.raw.manectric));
            pokeImages.add(new PokeImages("Flygon",R.raw.b_flygon,R.raw.flygon));
            pokeImages.add(new PokeImages("Pikachu",R.raw.b_pikachu,R.raw.pikachu));
            pokeImages.add(new PokeImages("Sceptile",R.raw.b_sceptile,R.raw.sceptile));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        random = rand.nextInt(5);

        black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_black()));


        findViewById(R.id.verificar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pokeImages.get(random).getNom().equals(nombrePoke.getText().toString())){
                    black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_color()));
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Correcto", Toast.LENGTH_SHORT);

                    toast1.show();
                    new CountDownTimer(3000,1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            random = rand.nextInt(5);
                            black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_black()));
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(),
                                            "El siguiente Pokemon", Toast.LENGTH_SHORT);

                            toast1.show();

                        }
                    }.start();

                }
            }
        });
    }







}

package com.example.dani.dgonzalezapp.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.model.PokeImages;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class GamePokemonActivity extends AppCompatActivity {
    List<PokeImages> pokeImages = new ArrayList<>();

    Button verificar,skip;
    ImageView black;
    int random;
    EditText nombrePoke;
    TextView scoreText,vidas;
    int score = 0;
    int vida = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_pokemon);


        Random rand = new Random();
        black = findViewById(R.id.imagePoke);
        nombrePoke =findViewById(R.id.textPoke);
        scoreText = findViewById(R.id.score);
        vidas = findViewById(R.id.vidas);
        skip = findViewById(R.id.skip);

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

        random = rand.nextInt(6);

        black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_black()));

        verificar = findViewById(R.id.verificar);

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pokeImages.get(random).getNom().equals(nombrePoke.getText().toString())){
                    black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_color()));
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Correct", Toast.LENGTH_SHORT);
                    toast1.show();

                    nombrePoke.setText("");

                    score = score+20;
                    scoreText.setText("Score: "+ score);


                    final KonfettiView konfettiView = findViewById(R.id.viewKonfetti);
                    konfettiView.build()
                            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                            .setDirection(0.0, 359.0)
                            .setSpeed(1f, 5f)
                            .setFadeOutEnabled(true)
                            .setTimeToLive(2000L)
                            .addShapes(Shape.RECT, Shape.CIRCLE)
                            .addSizes(new Size(12, 5))
                            .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                            .streamFor(300, 500L);

                    verificar.setClickable(false);
                    new CountDownTimer(3000,1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            random = rand.nextInt(6);
                            black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_black()));
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(),
                                            "Next Pokemon", Toast.LENGTH_SHORT);

                            toast1.show();
                            verificar.setClickable(true);

                        }
                    }.start();

                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Error", Toast.LENGTH_SHORT);

                    toast1.show();

                    nombrePoke.setText("");

                    vida = vida - 1;
                    vidas.setText("HP: "+ vida);

                    if(vida == 0){
                        verificar.setClickable(false);

                        AlertDialog.Builder builder = new AlertDialog.Builder(GamePokemonActivity.this);
                        builder.setTitle("YOU LOSE");
                        View viewInflate = LayoutInflater.from(GamePokemonActivity.this).inflate(R.layout.ventanaemergente,null);
                        builder.setView(viewInflate);

                        final EditText name = viewInflate.findViewById(R.id.username);

                        builder.setPositiveButton("Add your score", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String nameStr = name.getText().toString().trim();

                                Intent intent = new Intent(GamePokemonActivity.this, MenuThatPokemonActivity.class);
                                startActivity(intent);
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();

                        }
                    }
                }
            });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = rand.nextInt(6);

                black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_black()));
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Skip", Toast.LENGTH_SHORT);
                toast1.show();

                nombrePoke.setText("");
                vida = vida-1;
                vidas.setText("HP: "+ vida);
                verificar.setClickable(false);
                new CountDownTimer(3000,1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        verificar.setClickable(true);
                    }
                }.start();

                if(vida == 0){
                    verificar.setClickable(false);

                    AlertDialog.Builder builder = new AlertDialog.Builder(GamePokemonActivity.this);
                    builder.setTitle("YOU LOSE");
                    View viewInflate = LayoutInflater.from(GamePokemonActivity.this).inflate(R.layout.ventanaemergente,null);
                    builder.setView(viewInflate);

                    final EditText name = viewInflate.findViewById(R.id.username);

                    builder.setPositiveButton("Add your score", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {


                            Intent intent = new Intent(GamePokemonActivity.this, MenuThatPokemonActivity.class);
                            startActivity(intent);
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            }
        });
    }







}

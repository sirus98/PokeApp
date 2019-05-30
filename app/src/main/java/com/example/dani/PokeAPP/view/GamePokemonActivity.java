package com.example.dani.PokeAPP.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dani.PokeAPP.R;
import com.example.dani.PokeAPP.model.PokeImages;
import com.example.dani.PokeAPP.model.Ranking;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mehdi.sakout.fancybuttons.FancyButton;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class GamePokemonActivity extends AppCompatActivity {
    List<PokeImages> pokeImages = new ArrayList<>();
    DatabaseReference mReference;

    ImageView black, hp1, hp2, hp3,hp2Extra,hp3Extra,hp4Extra;
    int random;
    EditText nombrePoke, nameE;
    TextView scoreText;
    int score = 0;
    int vida = 3;
    boolean vidaExtra = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_pokemon);

        mReference = FirebaseDatabase.getInstance().getReference();
        Random rand = new Random();
        black = findViewById(R.id.imagePoke);
        nombrePoke = findViewById(R.id.textPoke);
        scoreText = findViewById(R.id.score);

        FancyButton verificar = findViewById(R.id.verificar);
        FancyButton skip = findViewById(R.id.skip);

        pokeImages.add(new PokeImages("Dragonite", R.raw.b_dragonite, R.raw.dragonite));
        pokeImages.add(new PokeImages("Snorlax", R.raw.b_snorlax, R.raw.snorlax));
        pokeImages.add(new PokeImages("Manectric", R.raw.b_manectric, R.raw.manectric));
        pokeImages.add(new PokeImages("Flygon", R.raw.b_flygon, R.raw.flygon));
        pokeImages.add(new PokeImages("Pikachu", R.raw.b_pikachu, R.raw.pikachu));
        pokeImages.add(new PokeImages("Sceptile", R.raw.b_sceptile, R.raw.sceptile));


        random = rand.nextInt(6);

        black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_black()));


        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pokeImages.get(random).getNom().equals(nombrePoke.getText().toString())) {
                    black.setImageDrawable(getResources().getDrawable(pokeImages.get(random).getImg_color()));
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Correct", Toast.LENGTH_SHORT);
                    toast1.show();

                    nombrePoke.setText("");

                    score = score + 20;
                    scoreText.setText("Score: " + score);

                    if (score == 20 && vida==3 && vidaExtra){

                        vida++;
                        System.out.println("ABC "+vida);
                        hp4Extra = findViewById(R.id.hp4Extra);
                        hp4Extra.setVisibility(View.VISIBLE);
                    }

                    if (score == 20 && vida==2 && vidaExtra){
                        vida++;
                        hp3Extra = findViewById(R.id.hp3Extra);
                        hp3Extra.setVisibility(View.VISIBLE);
                    }
                    if (score == 20 && vida==1 && vidaExtra){
                        vida++;
                        hp2Extra = findViewById(R.id.hp2Extra);
                        hp2Extra.setVisibility(View.VISIBLE);
                    }


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
                    new CountDownTimer(3000, 1000) {

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

                } else {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Error", Toast.LENGTH_SHORT);

                    toast1.show();

                    nombrePoke.setText("");

                    vida = vida - 1;
                    System.out.println("ABC "+vida);


                    if (vida == 3) {
                        hp4Extra = findViewById(R.id.hp4Extra);
                        hp4Extra.setVisibility(View.INVISIBLE);
                    }

                    if (vida == 2) {
                        hp3 = findViewById(R.id.hp3);
                        hp3.setVisibility(View.INVISIBLE);
                        hp3Extra = findViewById(R.id.hp3Extra);
                        hp3Extra.setVisibility(View.INVISIBLE);
                    }

                    if (vida == 1) {
                        hp2 = findViewById(R.id.hp2);
                        hp2.setVisibility(View.INVISIBLE);
                        hp2Extra = findViewById(R.id.hp2Extra);
                        hp2Extra.setVisibility(View.INVISIBLE);
                    }


                    if (vida == 0) {
                        hp1 = findViewById(R.id.hp1);
                        hp1.setVisibility(View.GONE);
                        verificar.setClickable(false);

                        AlertDialog.Builder builder = new AlertDialog.Builder(GamePokemonActivity.this);
                        builder.setTitle("YOU LOSE");
                        View viewInflate = LayoutInflater.from(GamePokemonActivity.this).inflate(R.layout.ventanaemergente, null);
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
                vida = vida - 1;

                verificar.setClickable(false);
                new CountDownTimer(3000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        verificar.setClickable(true);
                    }
                }.start();

                if (vida == 3) {
                    hp4Extra = findViewById(R.id.hp4Extra);
                    hp4Extra.setVisibility(View.INVISIBLE);
                }

                if (vida == 2) {
                    hp3 = findViewById(R.id.hp3);
                    hp3.setVisibility(View.INVISIBLE);
                    hp3Extra = findViewById(R.id.hp3Extra);
                    hp3Extra.setVisibility(View.INVISIBLE);
                }

                if (vida == 1) {
                    hp2 = findViewById(R.id.hp2);
                    hp2.setVisibility(View.INVISIBLE);
                    hp2Extra = findViewById(R.id.hp2Extra);
                    hp2Extra.setVisibility(View.INVISIBLE);
                }


                if (vida == 0) {
                    hp1 = findViewById(R.id.hp1);
                    hp1.setVisibility(View.INVISIBLE);

                    verificar.setClickable(false);

                    AlertDialog.Builder builder = new AlertDialog.Builder(GamePokemonActivity.this);
                    builder.setTitle("YOU LOSE");
                    View viewInflate = LayoutInflater.from(GamePokemonActivity.this).inflate(R.layout.ventanaemergente, null);
                    builder.setView(viewInflate);

                    nameE = viewInflate.findViewById(R.id.username);

                    builder.setPositiveButton("Add your score", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            String key = mReference.push().getKey();
                            String namee = nameE.getText().toString();

                            Ranking ranking = new Ranking(score, namee);

                            mReference.child("Ranking").child(key).setValue(ranking);


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

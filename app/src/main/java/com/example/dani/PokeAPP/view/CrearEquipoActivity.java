package com.example.dani.PokeAPP.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.dani.PokeAPP.GlideApp;
import com.example.dani.PokeAPP.R;
import com.example.dani.PokeAPP.model.Poke;
import com.example.dani.PokeAPP.model.Team;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CrearEquipoActivity extends AppCompatActivity {

    private DatabaseReference mRef;
    private String uid;
    boolean load = false;
    Boolean creado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_equipo);

        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();
        load = getIntent().getBooleanExtra("load", load);
        if(load){
            loadTeam();
        }

        findViewById(R.id.floating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CrearEquipoActivity.this, "Tu equipo ha sido añadido.", Toast.LENGTH_LONG).show();
                creado=true;
                Intent intent = new Intent(CrearEquipoActivity.this, EquiposActivity.class);
                intent.putExtra("creado", creado);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, PokedexActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, PokedexActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, PokedexActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, PokedexActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, PokedexActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageView6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, PokedexActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });
    }

    void loadTeam(){

        mRef.child("teams").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Team team = dataSnapshot.getValue(Team.class);

                int i =0;
                if (team != null && !team.pokemons.isEmpty()) {
                    for (Poke poke : team.pokemons.values()) {
                        System.out.println("ABCD -> i -> " + i);
                        if (i == 0) {
                            GlideApp.with(CrearEquipoActivity.this)
                                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + poke.id + ".png")
                                    .into((ImageView) findViewById(R.id.imageView));
                            findViewById(R.id.imageView).setClickable(false);
                        }

                        if (i == 1) {
                            GlideApp.with(CrearEquipoActivity.this)
                                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + poke.id + ".png")
                                    .into((ImageView) findViewById(R.id.imageView2));
                            findViewById(R.id.imageView2).setClickable(false);
                        }

                        if (i == 2) {
                            GlideApp.with(CrearEquipoActivity.this)
                                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + poke.id + ".png")
                                    .into((ImageView) findViewById(R.id.imageView3));
                            findViewById(R.id.imageView3).setClickable(false);

                        }

                        if (i == 3) {
                            GlideApp.with(CrearEquipoActivity.this)
                                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + poke.id + ".png")
                                    .into((ImageView) findViewById(R.id.imageView4));
                            findViewById(R.id.imageView4).setClickable(false);
                        }

                        if (i == 4) {
                            GlideApp.with(CrearEquipoActivity.this)
                                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + poke.id + ".png")
                                    .into((ImageView) findViewById(R.id.imageView5));
                            findViewById(R.id.imageView5).setClickable(false);
                        }

                        if (i == 5) {
                            GlideApp.with(CrearEquipoActivity.this)
                                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + poke.id + ".png")
                                    .into((ImageView) findViewById(R.id.imageView6));
                            findViewById(R.id.imageView6).setClickable(false);
                        }
                        i++;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        //Write your code here
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}

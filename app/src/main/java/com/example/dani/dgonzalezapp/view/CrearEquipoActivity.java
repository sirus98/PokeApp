package com.example.dani.dgonzalezapp.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dani.dgonzalezapp.GlideApp;
import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.database.DatabaseHelper;
import com.example.dani.dgonzalezapp.database.EquipoPokemon;
import com.example.dani.dgonzalezapp.model.Poke;
import com.example.dani.dgonzalezapp.model.Team;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CrearEquipoActivity extends AppCompatActivity {

    private DatabaseReference mRef;
    private String uid;

    boolean load = false;


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
                startActivity(new Intent(CrearEquipoActivity.this, EquiposActivity.class));
            }
        });


        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, MainActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });
        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, MainActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });


        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, MainActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });
        findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, MainActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, MainActivity.class);
                intent.putExtra("equipo", true);
                intent.putExtra("idEquipo", 0);
                startActivity(intent);
            }
        });
        findViewById(R.id.imageView6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, MainActivity.class);
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
                for(Poke poke: team.pokemons.values()){
                    System.out.println("ABCD -> i -> " + i);
                    if (i == 0) {
                        GlideApp.with(CrearEquipoActivity.this)
                                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+poke.id+".png")
                                .into((ImageView)findViewById(R.id.imageView));
                        findViewById(R.id.imageView).setClickable(false);
                    }
                    if(i==1){
                        GlideApp.with(CrearEquipoActivity.this)
                                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+poke.id+".png")
                                .into((ImageView)findViewById(R.id.imageView2));
                        findViewById(R.id.imageView2).setClickable(false);
                    }
                    if(i==2){
                        GlideApp.with(CrearEquipoActivity.this)
                                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+poke.id+".png")
                                .into((ImageView)findViewById(R.id.imageView3));
                        findViewById(R.id.imageView3).setClickable(false);

                    }

                    if(i==3){
                        GlideApp.with(CrearEquipoActivity.this)
                                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+poke.id+".png")
                                .into((ImageView)findViewById(R.id.imageView4));
                        findViewById(R.id.imageView4).setClickable(false);
                    }

                    if(i==4){
                        GlideApp.with(CrearEquipoActivity.this)
                                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+poke.id+".png")
                                .into((ImageView)findViewById(R.id.imageView5));
                        findViewById(R.id.imageView5).setClickable(false);
                    }
                    if(i==5){
                        GlideApp.with(CrearEquipoActivity.this)
                                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+poke.id+".png")
                                .into((ImageView)findViewById(R.id.imageView6));
                        findViewById(R.id.imageView6).setClickable(false);
                    }

                    i++;

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }
}

package com.example.dani.dgonzalezapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.database.DatabaseHelper;
import com.example.dani.dgonzalezapp.database.EquipoPokemon;

import java.util.ArrayList;
import java.util.List;

public class CrearEquipoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_equipo);

        DatabaseHelper dbHelper = new DatabaseHelper(getApplication());

        List<EquipoPokemon> list = new ArrayList<>();

//        list = dbHelper.getAllPokemonFromTeam("0");; TODO: dasdas

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
}

package com.example.dani.dgonzalezapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dani.dgonzalezapp.view.MainActivity;
import com.example.dani.dgonzalezapp.view.PokeListAdapter;

public class crear_equipo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_equipo);

        findViewById(R.id.floating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(crear_equipo.this, "Tu equipo ha sido añadido.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(crear_equipo.this, Equipos_Activity.class));
            }
        });



        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crear_equipo.this, MainActivity.class);
                intent.putExtra("equipo", true);
                startActivity(intent);
            }
        });













    }
}

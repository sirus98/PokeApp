package com.example.dani.dgonzalezapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class EquiposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_);

        Button btnCrear = (Button) findViewById(R.id.crearequipo);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquiposActivity.this, CrearEquipoActivity.class);
                startActivity(intent);
            }
        });


        Button btnVer = (Button) findViewById(R.id.verequipos);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquiposActivity.this, VerEquiposActivity.class);
                startActivity(intent);
            }
        });


        final ImageView prueba = findViewById(R.id.teams);

        @SuppressLint("ResourceType") final ConstraintLayout layout = findViewById(R.layout.activity_start_activity);

        Glide.with(this)
                .asGif()
                .load(R.raw.teams)
                .into(prueba);





    }
}

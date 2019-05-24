package com.example.dani.dgonzalezapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dani.dgonzalezapp.R;

public class CrearEquipoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_equipo);

        findViewById(R.id.floating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CrearEquipoActivity.this, "Tu equipo ha sido añadido.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(CrearEquipoActivity.this, EquiposActivity.class));
            }
        });



        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearEquipoActivity.this, MainActivity.class);
                intent.putExtra("equipo", true);
                startActivity(intent);
            }
        });













    }
}

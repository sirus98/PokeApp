package com.example.dani.dgonzalezapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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




    }
}

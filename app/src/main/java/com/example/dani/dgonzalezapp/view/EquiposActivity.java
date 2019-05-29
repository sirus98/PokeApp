package com.example.dani.dgonzalezapp.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dani.dgonzalezapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import mehdi.sakout.fancybuttons.FancyButton;

public class EquiposActivity extends AppCompatActivity {

    private DatabaseReference mRef;
    private String uid;
    boolean creado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_);

        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        creado= getIntent().getBooleanExtra("creado", creado);

        FancyButton btnCrear = findViewById(R.id.crearequipo);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(creado){
                    Toast.makeText(EquiposActivity.this, "El equipo ya está creado", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(EquiposActivity.this, CrearEquipoActivity.class);
                    startActivity(intent);

                }


            }
        });

        FancyButton btnVer = findViewById(R.id.verequipos);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquiposActivity.this, VerEquiposActivity.class);
                startActivity(intent);
            }
        });

        FancyButton btnBorrar = findViewById(R.id.borrarequipo);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.child("teams").child(uid).setValue(null);
                Toast.makeText(EquiposActivity.this, "Se ha eliminado el equipo", Toast.LENGTH_SHORT).show();
            }
        });

        FancyButton btnInicio = findViewById(R.id.menu);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(EquiposActivity.this,MenuActivity.class);
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

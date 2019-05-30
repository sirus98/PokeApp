package com.example.dani.PokeAPP.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dani.PokeAPP.R;
import com.example.dani.PokeAPP.model.Team;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import mehdi.sakout.fancybuttons.FancyButton;

public class EquiposActivity extends AppCompatActivity {

    boolean creado = false;
    private DatabaseReference mRef;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_);

        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        creado = getIntent().getBooleanExtra("creado", creado);

        FancyButton btnCrear = findViewById(R.id.crearequipo);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRef.child("teams").child(uid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            Toast.makeText(EquiposActivity.this, "Hay un equipo creado", Toast.LENGTH_LONG).show();


                        }else{
                            Intent intent = new Intent(EquiposActivity.this, CrearEquipoActivity.class);
                            startActivity(intent);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        FancyButton btnVer = findViewById(R.id.verequipos);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRef.child("teams").child(uid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            Intent intent = new Intent(EquiposActivity.this, VerEquiposActivity.class);


                            startActivity(intent);
                        }else{
                            Toast.makeText(EquiposActivity.this, "No hay equipo", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        });

        FancyButton btnBorrar = findViewById(R.id.borrarequipo);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creado = false;
                mRef.child("teams").child(uid).setValue(null);
                Toast.makeText(EquiposActivity.this, "Se ha eliminado el equipo", Toast.LENGTH_SHORT).show();
            }
        });

        FancyButton btnInicio = findViewById(R.id.menu);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquiposActivity.this, MenuActivity.class);
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

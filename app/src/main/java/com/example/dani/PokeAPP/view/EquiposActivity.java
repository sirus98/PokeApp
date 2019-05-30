package com.example.dani.PokeAPP.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dani.PokeAPP.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import mehdi.sakout.fancybuttons.FancyButton;

public class EquiposActivity extends AppCompatActivity {

    private DatabaseReference mRef;
    private String uid;
    boolean borrardatos= true;
    boolean haydatos= true;
    boolean creardatos= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_);

        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        FancyButton btnCrear = findViewById(R.id.crearequipo);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                creardatos=true;
                if (creardatos){
                    mRef.child("teams").child(uid).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                creardatos= false;

                            }else{
                                if (creardatos){
                                    Intent intent = new Intent(EquiposActivity.this, CrearEquipoActivity.class);
                                    startActivity(intent);
                                    creardatos= false;
                                }


                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

        FancyButton btnVer = findViewById(R.id.verequipos);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                haydatos=true;

                if (haydatos){

                    mRef.child("teams").child(uid).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                Intent intent = new Intent(EquiposActivity.this, VerEquiposActivity.class);
                                startActivity(intent);
                                haydatos=false;
                            }else{
                                Toast.makeText(EquiposActivity.this, "No hay equipo", Toast.LENGTH_SHORT).show();
                                haydatos=false;
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


            }

        });

        FancyButton btnBorrar = findViewById(R.id.borrarequipo);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                borrardatos= true;
                mRef.child("teams").child(uid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(borrardatos) {
                            if (dataSnapshot.exists()) {
                                mRef.child("teams").child(uid).setValue(null);
                                Toast.makeText(EquiposActivity.this, "Se ha eliminado el equipo", Toast.LENGTH_SHORT).show();
                                borrardatos= false;

                            } else {
                                Toast.makeText(EquiposActivity.this, "No hay equipo", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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

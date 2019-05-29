package com.example.dani.PokeAPP.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.bumptech.glide.Glide;
import com.example.dani.PokeAPP.R;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        boolean gmail = getIntent().getBooleanExtra("gmail",false);

        findViewById(R.id.ListaPokemon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuActivity.this, PokedexActivity.class);
                intent.putExtra("gmail", gmail);
                intent.putExtra("equipo", false);
                startActivity(intent);
            }
        });


        findViewById(R.id.Thatpokemon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuActivity.this, MenuThatPokemonActivity.class);
                intent.putExtra("who's that pokemon", false);
                intent.putExtra("gmail", gmail);
                startActivity(intent);
            }
        });


        findViewById(R.id.AdministrarEquipos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MenuActivity.this, EquiposActivity.class);
                intent.putExtra("gmail", gmail);
                startActivity(intent);
            }
        });

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {

            Glide.with(this)
                    .load(firebaseUser.getPhotoUrl().toString());

            findViewById(R.id.sign_out).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AuthUI.getInstance()
                            .signOut(MenuActivity.this)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                public void onComplete(@NonNull Task<Void> task) {
                                    startActivity(new Intent(MenuActivity.this, StartActivity.class));
                                    finish();
                                }
                            });
                }
            });
        }

    }
}

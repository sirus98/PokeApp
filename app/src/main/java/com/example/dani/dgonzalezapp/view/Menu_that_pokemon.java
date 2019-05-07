package com.example.dani.dgonzalezapp.view;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dani.dgonzalezapp.R;

public class Menu_that_pokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_that_pokemon);


        final ImageView gastly = findViewById(R.id.gastly);

        @SuppressLint("ResourceType") final ConstraintLayout layout = findViewById(R.layout.activity_menu_that_pokemon);

        Glide.with(this)
                .asGif()
                .load(R.raw.gastly)
                .into(gastly);
    }
}

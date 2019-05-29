package com.example.dani.dgonzalezapp.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import com.example.dani.dgonzalezapp.MainViewModel;
import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.database.DatabaseHelper;
import com.example.dani.dgonzalezapp.database.EquipoPokemon;
import com.example.dani.dgonzalezapp.model.Poke;
import com.firebase.ui.database.FirebaseArray;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.io.IOException;
import java.util.ArrayList;


public class PokeActivity extends AppCompatActivity {

    private MainViewModel pokeViewModel;
    DatabaseReference mRef;
    String uid;

    MediaPlayer player;
    TextView tv_name;
    TextView tv_id;
    TextView tv_url;
    ImageView iv_imagen;
    ConstraintLayout contenedor;

    boolean load;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_show);

        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        final String url = getIntent().getExtras().getString("pokemon_url");

        tv_name = findViewById(R.id.name);
        tv_id = findViewById(R.id.id);
        iv_imagen = findViewById(R.id.imagen);
        contenedor = findViewById(R.id.layoutPokemon);

        FloatingActionButton addequipo = findViewById(R.id.añadirequipo);



        boolean equipo = getIntent().getBooleanExtra("equipo", false);

        if (equipo) {
            addequipo.setVisibility(View.VISIBLE);
        }

        pokeViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        pokeViewModel.getPokemon(url).observe(this, new Observer<Poke>() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onChanged(@Nullable Poke poke) {
                tv_name.setText(poke.name);
                int size = String.valueOf(poke.id).length();
                if (size == 1) tv_id.setText("#00" + String.valueOf(poke.id));
                else if (size == 2) tv_id.setText("#0" + String.valueOf(poke.id));
                else tv_id.setText("#" + String.valueOf(poke.id));

                String soundfile = "m"+String.format("%03d",poke.id)+".wav";
                Log.e("abc", soundfile);

                AssetFileDescriptor afd = null;
                try {
                    afd = getAssets().openFd(soundfile);
                    player = new MediaPlayer();
                    player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Glide.with(PokeActivity.this)
                        .asBitmap()
                        .load("http://pokestadium.com/sprites/xy/" + poke.name + ".gif")
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                                    @Override
                                    public void onGenerated(@Nullable Palette palette) {
                                        contenedor.setBackgroundColor(palette.getLightVibrantColor(Color.CYAN));
                                    }
                                });
                            }
                        });


                Glide.with(PokeActivity.this)
                        .load("http://pokestadium.com/sprites/xy/" + poke.name + ".gif")
                        .into(iv_imagen);

                HorizontalBarChart chart = findViewById(R.id.chart);
                BarData data = new BarData(getXAxisValues(), getDataSet());
                chart.setData(data);

                chart.setDescription("");

                chart.animateXY(2000, 2000);

                chart.getAxisLeft().setDrawGridLines(false);
                chart.getXAxis().setDrawGridLines(false);

                chart.setBackgroundColor(Color.TRANSPARENT);
                chart.setDrawGridBackground(false);

                chart.invalidate();

                findViewById(R.id.añadirequipo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
//

                        Log.e("abc", poke.id + " " + poke.name + " " + poke.url);
                        mRef.child("teams").child(uid).child("pokemons").push().setValue(poke);
                        Intent intent = new Intent(PokeActivity.this, CrearEquipoActivity.class);
                        load = true;
                        intent.putExtra("load", load);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        Toast.makeText(PokeActivity.this, "Pokemon Añadido", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }






    private ArrayList<BarDataSet> getDataSet(){
        ArrayList<BarDataSet> dataSets = null;


        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);


        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand b_2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet2);
        return dataSets;


    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("hp");
        xAxis.add("atk");
        xAxis.add("def");
        xAxis.add("sAt");
        xAxis.add("sDf");
        xAxis.add("spd");
        return xAxis;

    }
}
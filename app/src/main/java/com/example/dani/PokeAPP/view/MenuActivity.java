package com.example.dani.PokeAPP.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;

import com.bumptech.glide.Glide;
import com.example.dani.PokeAPP.R;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;


public class MenuActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private float acelVal;  //current acceleration and gravity
    private float acelLast; //last acceleration and gravity
    private float shake;    //acceleration value differ from gravity
    MediaPlayer player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        player2 = new MediaPlayer();


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(sensorListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = sensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

        findViewById(R.id.ListaPokemon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, PokedexActivity.class);
                intent.putExtra("equipo", false);
                startActivity(intent);
            }
        });


        findViewById(R.id.Thatpokemon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MenuThatPokemonActivity.class);
                intent.putExtra("who's that pokemon", false);
                startActivity(intent);
            }
        });


        findViewById(R.id.AdministrarEquipos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, EquiposActivity.class);
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
    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 12 && !player2.isPlaying() ){
                String soundfile = "Lugia"  + ".wav";
                AssetFileDescriptor afd = null;
                try {
                    afd = getAssets().openFd(soundfile);
                    player2.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    player2.prepare();
                    player2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player2.stop();
                            player2.reset();
                        }
                    });
                    player2.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
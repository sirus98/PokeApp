package com.example.dani.dgonzalezapp.model;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.view.MainActivity;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class PokeImages {


    String nom;
    int img_black;
    int img_color;


    public PokeImages(String nom, int img_black, int img_color) throws MalformedURLException {
        this.nom = nom;
        this.img_black = img_black;
        this.img_color = img_color;
    }




    public String getNom() {
        return nom;


    }



    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getImg_black() {
        return img_black;
    }
    public int getImg_color() {
        return img_color;
    }


}

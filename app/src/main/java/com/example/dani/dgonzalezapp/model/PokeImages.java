package com.example.dani.dgonzalezapp.model;


public class PokeImages {
    String nom;
    int img_black;
    int img_color;

    public PokeImages(String nom, int img_black, int img_color){
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

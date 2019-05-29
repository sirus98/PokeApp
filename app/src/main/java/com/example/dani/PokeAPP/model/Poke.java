package com.example.dani.PokeAPP.model;

public class Poke {
    public String name;
    public String url;
    public int id;

    public int lastIdPart(){
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length-1]);
    }
}
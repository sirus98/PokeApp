package com.example.dani.dgonzalezapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Poke implements Serializable {
    public String name;
    public String url;
    public int id;

    public Sprites sprites;
    public List<Types> types;
    public Species species;

    public int getId(){
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length-1]);
    }
}
package com.example.dani.dgonzalezapp.model;

import android.arch.persistence.room.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Poke {
    public String name;
    public String url;
    public int id;

    public int lastIdPart(){
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length-1]);
    }
}
package com.example.dani.dgonzalezapp.model;

import java.io.Serializable;

public class Types implements Serializable {

    public String name;

    public String getName() {
        return name.toString() ;
    }

    public void setName(String name) {
        this.name = name;
    }

}

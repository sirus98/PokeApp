package com.example.dani.PokeAPP.db.dbmodel;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class DbPokeTeam {
    @PrimaryKey(autoGenerate = true)
    public int teamId;
    public String name;
}

package com.example.dani.PokeAPP.db.dbmodel;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class DbPoke {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String photoUrl;
    public int teamId;
}

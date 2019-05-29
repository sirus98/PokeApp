package com.example.dani.PokeAPP.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.dani.PokeAPP.db.dbmodel.DbPoke;
import com.example.dani.PokeAPP.db.dbmodel.DbPokeTeam;

@Dao
public abstract class Pokedao {

    @Insert
    public abstract void insertPoke(DbPoke dbPoke);

    @Insert
    public abstract void insertTeam(DbPokeTeam dbPokeTeam);



}

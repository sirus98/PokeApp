package com.example.dani.PokeAPP.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.dani.PokeAPP.db.dbmodel.DbPoke;
import com.example.dani.PokeAPP.db.dbmodel.DbPokeTeam;

@Database(entities = {DbPoke.class, DbPokeTeam.class}, version = 1)
public abstract class Pokedb extends RoomDatabase {

    public abstract Pokedao pokedao();

    private static volatile Pokedb INSTANCE;

    public static Pokedb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Pokedb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Pokedb.class, "poke_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
package com.example.dani.dgonzalezapp.database;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.audiofx.DynamicsProcessing;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, DatabaseOptions.DB_NAME, null, DatabaseOptions.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        db.execSQL(DatabaseOptions.TEAM_TABLE);
        db.execSQL(DatabaseOptions.TEAM_POKEMON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL(" DROP TABLE IF EXISTS " + DatabaseOptions.TEAM_TABLE);
        db.execSQL(" DROP TABLE IF EXISTS " + DatabaseOptions.TEAM_POKEMON_TABLE);
        // Create tables again
        onCreate(db);
    }

    private String queryCheckRecent(EquipoPokemon equipoPokemon) {
        SQLiteDatabase db = this.getReadableDatabase();
        String idPokemon = "";

        Cursor cursor = db.rawQuery("SELECT count(IdPokemon) FROM " + DatabaseOptions.TEAM_POKEMON_TABLE + " ORDER BY IdPokemon DESC", null);

        if (cursor != null) cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    idPokemon = cursor.getString(cursor.getColumnIndex(DatabaseOptions.ID_POKEMON));

                    cursor.moveToNext();
                }
            }
            cursor.close();
        }

        return idPokemon;
    }

    public LiveData<List<EquipoPokemon>> getAllPokemonFromTeam (String idEquipo) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<EquipoPokemon> pokemonList = new ArrayList<>();
        EquipoPokemon equipoPokemon;

        final MutableLiveData<List<EquipoPokemon>> lista = new MutableLiveData<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseOptions.TEAM_POKEMON_TABLE + " WHERE IdEquipo = " + idEquipo + " ORDER BY DATE DESC", null);

        if (cursor != null) cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    String idPokemon = cursor.getString(cursor.getColumnIndex(DatabaseOptions.ID_POKEMON));
                    String name = cursor.getString(cursor.getColumnIndex(DatabaseOptions.NAME));
                    String image = cursor.getString(cursor.getColumnIndex(DatabaseOptions.IMAGE));

                    equipoPokemon = new EquipoPokemon(idEquipo, idPokemon, image, name);
                    pokemonList.add(equipoPokemon);
                    cursor.moveToNext();
                }
            }
            lista.setValue(pokemonList);
            cursor.close();
        }

        return lista;
    }

    public void addPokemonToTeam (EquipoPokemon equipoPokemon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String check = queryCheckRecent(equipoPokemon);

        values.put(DatabaseOptions.ID, equipoPokemon.getIdEquipo());
        values.put(DatabaseOptions.ID_POKEMON, equipoPokemon.getIdPokemon());
        values.put(DatabaseOptions.NAME, equipoPokemon.getName());
        values.put(DatabaseOptions.IMAGE, equipoPokemon.getImage());

        // Inserting Row
        db.insert(DatabaseOptions.CREATE_TEAM_POKEMON, null, values);


        db.close(); // Closing database connection
    }
}
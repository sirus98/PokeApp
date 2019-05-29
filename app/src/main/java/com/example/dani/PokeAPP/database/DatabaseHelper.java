package com.example.dani.PokeAPP.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, DatabaseOptions.DB_NAME, null, DatabaseOptions.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        db.execSQL(DatabaseOptions.CREATE_TEAM);
        db.execSQL(DatabaseOptions.CREATE_TEAM_POKEMON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL(" DROP TABLE IF EXISTS " + DatabaseOptions.TEAM_TABLE);
        db.execSQL(" DROP TABLE IF EXISTS " + DatabaseOptions.TEAM_POKEMON_TABLE);
        // Create tables again
        onCreate(db);
    }

    public List<EquipoPokemon> getAllPokemonFromTeam (String idEquipo) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<EquipoPokemon> pokemonList = new ArrayList<>();
        EquipoPokemon equipoPokemon;

        final List<EquipoPokemon> lista = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseOptions.TEAM_POKEMON_TABLE + " WHERE id = '" + idEquipo + "' ORDER BY id_pokemon", null);

        System.out.println("ABCD -> count cursor " + cursor.getCount());

        if (cursor != null) cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    String id = cursor.getString(cursor.getColumnIndex(DatabaseOptions.ID));
                    String idPokemon = cursor.getString(cursor.getColumnIndex(DatabaseOptions.ID_POKEMON));
                    String name = cursor.getString(cursor.getColumnIndex(DatabaseOptions.NAME));
                    String image = cursor.getString(cursor.getColumnIndex(DatabaseOptions.IMAGE));

                    equipoPokemon = new EquipoPokemon(id, idPokemon, image, name);

                    System.out.println("ABCD -> Pokemon -> " + equipoPokemon.toString());

                    pokemonList.add(equipoPokemon);
                    cursor.moveToNext();
                }
            }
            lista.addAll(pokemonList);
            cursor.close();
        }

        return lista;
    }

    private boolean queryCheckRecent(EquipoPokemon equipoPokemon) {
        SQLiteDatabase db = this.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = db.query(DatabaseOptions.TEAM_POKEMON_TABLE,
                new String[]{DatabaseOptions.ID},
                DatabaseOptions.ID + "=?",
                new String[]{equipoPokemon.getIdEquipo()}, null, null, null, "1");
        if (cursor != null)
            cursor.moveToFirst();
        return cursor != null && cursor.getCount() > 0;
    }

    public void addPokemonToTeam (EquipoPokemon equipoPokemon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        boolean check = queryCheckRecent(equipoPokemon);

        if (check) {
            Cursor cursor = db.rawQuery("select count(*) + 1 from users where id='" + "0" + "'", null);
            cursor.moveToFirst();
            int count = cursor.getInt(0);
            cursor.close();

            values.put(DatabaseOptions.ID, equipoPokemon.getIdEquipo());
            values.put(DatabaseOptions.ID_POKEMON, String.valueOf(count));
            values.put(DatabaseOptions.NAME, equipoPokemon.getName());
            values.put(DatabaseOptions.IMAGE, equipoPokemon.getImage());

            // Inserting Row
            db.insert(DatabaseOptions.TEAM_POKEMON_TABLE, null, values);
        } else {
            values.put(DatabaseOptions.ID, "0");
            values.put(DatabaseOptions.ID_POKEMON, "0");
            values.put(DatabaseOptions.NAME, equipoPokemon.getName());
            values.put(DatabaseOptions.IMAGE, equipoPokemon.getImage());

            // Inserting Row
            db.insert(DatabaseOptions.TEAM_POKEMON_TABLE, null, values);
        }


        db.close(); // Closing database connection
    }
}
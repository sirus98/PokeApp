package com.example.dani.PokeAPP.database;

public class DatabaseOptions {

    static final String DB_NAME = "local.db";
    static final int DB_VERSION = 1;

    static final String TEAM_TABLE = "team";
    static final String TEAM_POKEMON_TABLE = "team_pokemon";

    public static final String ID = "id";
    public static final String ID_POKEMON = "id_pokemon";
    static final String NAME = "name";
    static final String IMAGE = "image";

    static final String CREATE_TEAM =
            "CREATE TABLE " + TEAM_TABLE + "(" +
                    ID + " TEXT NOT NULL," +
                    NAME + " TEXT NOT NULL);" ;

    static final String CREATE_TEAM_POKEMON =
            "CREATE TABLE " + TEAM_POKEMON_TABLE + "(" +
                    ID + " TEXT NOT NULL," +
                    ID_POKEMON + " TEXT NOT NULL," +
                    NAME + " TEXT NOT NULL," +
                    IMAGE + "TEXT NOT NULL" + ");";
}


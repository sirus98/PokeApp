package com.example.dani.PokeAPP.api;
import com.example.dani.PokeAPP.model.Poke;
import com.example.dani.PokeAPP.model.PokeList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PokedbAPI {
    @GET("/api/v2/pokemon/?limit=950")
    Call<PokeList> getPokemonList();

    @GET
    Call<Poke> getPokemon(@Url String url);
}
package com.example.dani.dgonzalezapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.dani.dgonzalezapp.api.PokedbAPI;
import com.example.dani.dgonzalezapp.api.PokedbModule;
import com.example.dani.dgonzalezapp.model.Poke;
import com.example.dani.dgonzalezapp.model.PokeList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokedbRepository {
    PokedbAPI pokedbAPI;

    public PokedbRepository(){
        pokedbAPI = PokedbModule.getAPI();
    }

    public LiveData<List<Poke>> getPokemonList(){
        final MutableLiveData<List<Poke>> lista = new MutableLiveData<>();

        pokedbAPI.getPokemonList().enqueue(new Callback<PokeList>() {
            @Override
            public void onResponse(Call<PokeList> call, Response<PokeList> response) {
                lista.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<PokeList> call, Throwable t) {}
        });

        return lista;    }

    public LiveData<Poke> getPokemon(String url){
        final MutableLiveData<Poke> poke = new MutableLiveData<>();

        pokedbAPI.getPokemon(url).enqueue(new Callback<Poke>() {
            @Override
            public void onResponse(Call<Poke> call, Response<Poke> response) {
                poke.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Poke> call, Throwable t) {}
        });

        return poke;
    }
}
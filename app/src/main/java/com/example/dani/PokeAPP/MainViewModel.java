package com.example.dani.PokeAPP;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.dani.PokeAPP.db.Pokedao;
import com.example.dani.PokeAPP.db.Pokedb;
import com.example.dani.PokeAPP.model.Poke;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private PokedbRepository pokedbRepository;
    private Pokedao pokedao;

    public MainViewModel(@NonNull Application application) {
        super(application);
        pokedbRepository = new PokedbRepository();
        pokedao = Pokedb.getDatabase(application).pokedao();
    }

    public LiveData<List<Poke>> getPokemons() {
        return pokedbRepository.getPokemonList();
    }

    public LiveData<Poke> getPokemon(String url) {
        return pokedbRepository.getPokemon(url);
    }

}
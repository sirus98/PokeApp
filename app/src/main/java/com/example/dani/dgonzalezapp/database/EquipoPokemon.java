package com.example.dani.dgonzalezapp.database;

public class EquipoPokemon {
    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(String idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String idEquipo;
    private String idPokemon;
    private String image;
    private String name;

    public EquipoPokemon(String idEquipo, String idPokemon, String image, String name) {
        this.idEquipo = idEquipo;
        this.idPokemon = idPokemon;
        this.image = image;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EquipoPokemon{" +
                "idEquipo='" + idEquipo + '\'' +
                ", idPokemon='" + idPokemon + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

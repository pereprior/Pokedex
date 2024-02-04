package com.example.pokedex2.data.mappers.pokemon

import com.example.pokedex2.data.mappers.IDataMapper
import com.example.pokedex2.data.sources.dto.pokemon.list.PokemonListDTO

class PokemonListDataMapper(
    private val pokemonList: PokemonListDTO
) : IDataMapper {
    // Convertimos un ListDTO en una lista de nombres de pokemon
    override fun convert(): List<String> {
        val pokemonListConverted = ArrayList<String>()

        pokemonList.results.map {
            pokemonListConverted.add(it.name)
        }

        return pokemonListConverted
    }
}
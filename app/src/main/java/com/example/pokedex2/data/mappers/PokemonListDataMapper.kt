package com.example.pokedex2.data.mappers

import com.example.pokedex2.data.sources.remote.dto.list.PokemonListDTO

class PokemonListDataMapper(
    private val pokemonList: PokemonListDTO
) : IDataMapper {
    override fun convert(): List<String> {
        val pokemonListConverted = ArrayList<String>()

        pokemonList.results.map {
            pokemonListConverted.add(it.name)
        }

        return pokemonListConverted
    }
}
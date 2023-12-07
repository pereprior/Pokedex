package com.example.pokedex2.model.api

import com.example.pokedex2.model.api.pokemon.PokemonResult
import com.example.pokedex2.model.data.Pokemon

class PokedexRepository(
    private val api: IPokedexApi
) {
    suspend fun getPokemons(): Result<List<Pokemon>> {
        return try {
            val response = api.getPokemons().results
            val pokemons = response.map { converter(it) }
            Result.success(pokemons)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun converter(p:PokemonResult):Pokemon{
        return Pokemon(
            name = p.name
        )
    }
}
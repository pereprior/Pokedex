package com.example.pokedex2.model.api

import com.example.pokedex2.model.data.Pokemon

class PokedexRepository(
    private val api: IPokedexApi
) {
    private val convert = Convert()

    suspend fun getPokemons(): Result<List<Pokemon>> {
        return try {
            val response = api.getPokemons().results
            val pokemons = response.map { convert.pokemon(it) }
            Result.success(pokemons)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
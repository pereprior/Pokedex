package com.example.pokedex2.model

import com.example.pokedex2.model.api.IPokedexApi
import com.example.pokedex2.model.api.ability.Ability
import com.example.pokedex2.model.api.move.Move
import com.example.pokedex2.model.api.pokemon.Pokemon
import com.example.pokedex2.model.api.type.Type

class PokedexRepository(
    private val api: IPokedexApi
) {
    suspend fun getPokemonInfo(dexNumber:Int): Result<Pokemon> {
        return try {
            val response = api.getPokemonInfo(dexNumber)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getTypes(id:Int): Result<Type> {
        return try {
            val response = api.getTypes(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getAbility(id:Int): Result<Ability> {
        return try {
            val response = api.getAbility(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getMove(id:Int): Result<Move> {
        return try {
            val response = api.getMove(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
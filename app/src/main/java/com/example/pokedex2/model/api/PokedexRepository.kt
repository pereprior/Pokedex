package com.example.pokedex2.model.api

import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.model.api.response.ability.AbilityInfo
import com.example.pokedex2.model.api.response.item.ItemInfo
import com.example.pokedex2.model.api.response.move.MoveInfo
import com.example.pokedex2.model.api.response.pokemon.PokemonInfo
import com.example.pokedex2.model.api.response.type.TypeInfo

class PokedexRepository(
    private val api: IPokedexApi
) {
    suspend fun getGenericData(item:String): Result<PokedexResponse> {
        return try {
            val response = api.getResponse(item)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPokemonInfo(dexNumber:Int): Result<PokemonInfo> {
        return try {
            val response = api.getPokemonInfo(dexNumber)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getTypes(id:Int): Result<TypeInfo> {
        return try {
            val response = api.getTypes(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getAbility(id:Int): Result<AbilityInfo> {
        return try {
            val response = api.getAbility(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getMove(id:Int): Result<MoveInfo> {
        return try {
            val response = api.getMove(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getItem(id:Int): Result<ItemInfo> {
        return try {
            val response = api.getItem(id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
package com.example.pokedex2.data.repositories

import android.util.Log
import com.example.pokedex2.data.mappers.PokemonDetailDataMapper
import com.example.pokedex2.data.mappers.PokemonListDataMapper
import com.example.pokedex2.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex2.domain.repositories.PokemonRepository
import com.example.pokedex2.domain.models.Pokemon
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource,
) : PokemonRepository {
    override suspend fun getListData(dataName:String): List<String> {
        return try {
            val result = remoteDataSource.getListDataFromApi(dataName)
            PokemonListDataMapper(result).convert()
        } catch (e: Exception) {
            return emptyList()
        }
    }

    override suspend fun getDetailData(dataName:String): Pokemon {
        return try {
            val result = remoteDataSource.getDetailDataFromApi(dataName)
            PokemonDetailDataMapper(result).convert()
        } catch (e: Exception) {
            Log.e("PokemonRepositoryImpl", "Error fetching Pokemon details", e)
            Pokemon()
        }
    }

}
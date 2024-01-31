package com.example.pokedex2.data.repositories

import com.example.pokedex2.data.mappers.PokemonDetailDataMapper
import com.example.pokedex2.data.mappers.PokemonListDataMapper
import com.example.pokedex2.data.sources.dto.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.list.PokemonListDTO
import com.example.pokedex2.data.sources.local.file.PokemonFileDataSource
import com.example.pokedex2.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex2.domain.repositories.PokemonRepository
import com.example.pokedex2.domain.models.Pokemon

class PokemonRepositoryImpl(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val fileDataSource: PokemonFileDataSource
) : PokemonRepository {
    override suspend fun getListData(dataName:String): List<String> {
        val result: PokemonListDTO = try {
            remoteDataSource.getListDataFromApi(dataName)
        } catch (e: Exception) {
            fileDataSource.obtainListFromJson(dataName)
        }

        return PokemonListDataMapper(result).convert()
    }

    override suspend fun getDetailData(dataName:String): Pokemon {
        val result: PokemonDetailDTO = try {
            remoteDataSource.getDetailDataFromApi(dataName)
        } catch (e: Exception) {
            fileDataSource.obtainDetailsFromJson(dataName)
        }

        return PokemonDetailDataMapper(result).convert()
    }
}
package com.example.pokedex2.data.repositories

import com.example.pokedex2.data.mappers.pokemon.PokemonDetailDataMapper
import com.example.pokedex2.data.mappers.pokemon.PokemonListDataMapper
import com.example.pokedex2.data.sources.dto.pokemon.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.pokemon.list.PokemonListDTO
import com.example.pokedex2.data.sources.local.file.PokemonFileDataSource
import com.example.pokedex2.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex2.domain.repositories.IRepository
import com.example.pokedex2.domain.models.Pokemon

class PokemonRepositoryImpl(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val fileDataSource: PokemonFileDataSource
) : IRepository {
    // Obtenemos la lista de pokemon, si no podemos de la api del fichero Json
    override suspend fun getListData(dataName:String): List<String> {
        val result: PokemonListDTO = try {
            remoteDataSource.getListDataFromApi(dataName)
        } catch (e: Exception) {
            fileDataSource.obtainListFromJson(dataName)
        }

        return PokemonListDataMapper(result).convert()
    }

    // Obtenemos los datos de un pokemon, si no podemos de la api del fichero json
    override suspend fun getDetailData(dataName:String): Pokemon {
        val result: PokemonDetailDTO = try {
            remoteDataSource.getDetailDataFromApi(dataName)
        } catch (e: Exception) {
            fileDataSource.obtainDetailsFromJson(dataName)
        }

        return PokemonDetailDataMapper(result).convert()
    }
}
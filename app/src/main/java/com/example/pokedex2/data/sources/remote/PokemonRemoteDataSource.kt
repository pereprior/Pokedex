package com.example.pokedex2.data.sources.remote

import com.example.pokedex2.data.sources.dto.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.list.PokemonListDTO
import com.example.pokedex2.domain.repositories.IRemoteDataSource

class PokemonRemoteDataSource(
    private val api: PokemonApiService
): IRemoteDataSource {
    override suspend fun getListDataFromApi(dataName:String): PokemonListDTO {
        return api.getDataList(dataName)
    }

    override suspend fun getDetailDataFromApi(dataName:String): PokemonDetailDTO {
        return api.getDataDetails(dataName)
    }

}
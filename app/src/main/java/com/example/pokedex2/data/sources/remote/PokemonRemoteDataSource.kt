package com.example.pokedex2.data.sources.remote

import com.example.pokedex2.data.sources.remote.dto.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.remote.dto.list.PokemonListDTO

class PokemonRemoteDataSource(
    private val api: PokemonApiService
) {
    suspend fun getListDataFromApi(dataName:String): PokemonListDTO {
        return api.getDataList(dataName)
    }

    suspend fun getDetailDataFromApi(dataName:String): PokemonDetailDTO {
        return api.getDataDetails(dataName)
    }

}
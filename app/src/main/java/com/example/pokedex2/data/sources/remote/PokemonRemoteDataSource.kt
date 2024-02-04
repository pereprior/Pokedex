package com.example.pokedex2.data.sources.remote

import com.example.pokedex2.data.sources.dto.pokemon.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.pokemon.list.PokemonListDTO
import com.example.pokedex2.domain.repositories.IRemoteDataSource

class PokemonRemoteDataSource(
    private val api: ApiService
): IRemoteDataSource {

    // Obtenemos la lista de pokemon desde la api
    override suspend fun getListDataFromApi(dataName:String): PokemonListDTO {
        return api.getDataList(dataName)
    }

    // Obtenemos los datos de un pokemon en especifico desde la api
    override suspend fun getDetailDataFromApi(dataName:String): PokemonDetailDTO {
        return api.getDataDetails(dataName)
    }

}
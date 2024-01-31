package com.example.pokedex2.domain.repositories

import com.example.pokedex2.data.sources.dto.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.list.PokemonListDTO

interface IRemoteDataSource {
    suspend fun getListDataFromApi(dataName:String): PokemonListDTO
    suspend fun getDetailDataFromApi(dataName:String): PokemonDetailDTO
}
package com.example.pokedex2.domain.repositories

import com.example.pokedex2.data.sources.dto.pokemon.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.pokemon.list.PokemonListDTO

interface IRemoteDataSource {
    suspend fun getListDataFromApi(dataName:String): PokemonListDTO
    suspend fun getDetailDataFromApi(dataName:String): PokemonDetailDTO
}
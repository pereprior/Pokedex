package com.example.pokedex2.data.sources.remote

import com.example.pokedex2.constants.API_UNLIMIT_KEY
import com.example.pokedex2.data.sources.dto.pokemon.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.pokemon.list.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{item}$API_UNLIMIT_KEY")
    suspend fun getDataList(
        @Path("item") item:String
    ): PokemonListDTO

    @GET("pokemon/{id}")
    suspend fun getDataDetails(
        @Path("id") id:String
    ): PokemonDetailDTO
}
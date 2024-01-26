package com.example.pokedex2.data.sources.remote

import com.example.pokedex2.data.sources.remote.dto.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.remote.dto.list.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("{item}?limit=100000&offset=0")
    suspend fun getDataList(
        @Path("item") item:String
    ): PokemonListDTO

    @GET("pokemon/{id}")
    suspend fun getDataDetails(
        @Path("id") id:String
    ): PokemonDetailDTO
}
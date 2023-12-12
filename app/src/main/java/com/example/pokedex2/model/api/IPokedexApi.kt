package com.example.pokedex2.model.api

import com.example.pokedex2.model.api.ability.Ability
import com.example.pokedex2.model.api.move.Move
import com.example.pokedex2.model.api.pokemon.Pokemon
import com.example.pokedex2.model.api.type.Type
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokedexApi {
    companion object {
        val instance: IPokedexApi = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IPokedexApi::class.java)
    }

    @GET("pokemon/{dex}")
    suspend fun getPokemonInfo(
        @Path("dex") dex:Int
    ): Pokemon


    @GET("type/{id}")
    suspend fun getTypes(
        @Path("id") id:Int
    ): Type

    @GET("ability/{id}")
    suspend fun getAbility(
        @Path("id") id:Int
    ): Ability

    @GET("move/{id}")
    suspend fun getMove(
        @Path("id") id:Int
    ): Move
}
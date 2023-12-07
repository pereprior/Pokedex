package com.example.pokedex2.model.api

import com.example.pokedex2.model.api.pokemon.PokemonResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface IPokedexApi {
    companion object {
        val instance: IPokedexApi = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IPokedexApi::class.java)
    }

    @GET("pokemon?limit=100000&offset=0")
    suspend fun getPokemons(): PokemonResponse
}
package com.example.pokedex2.model.api

import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.model.api.response.ability.AbilityInfo
import com.example.pokedex2.model.api.response.item.CategoryInfo
import com.example.pokedex2.model.api.response.item.ItemInfo
import com.example.pokedex2.model.api.response.item.PocketInfo
import com.example.pokedex2.model.api.response.move.MoveInfo
import com.example.pokedex2.model.api.response.pokemon.PokemonInfo
import com.example.pokedex2.model.api.response.type.TypeInfo
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

    @GET("{item}?limit=100000&offset=0")
    suspend fun getResponse(
        @Path("item") item:String
    ): PokedexResponse

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id:String
    ): PokemonInfo

    @GET("type/{id}")
    suspend fun getTypes(
        @Path("id") id:String
    ): TypeInfo

    @GET("ability/{id}")
    suspend fun getAbility(
        @Path("id") id:String
    ): AbilityInfo

    @GET("move/{id}")
    suspend fun getMove(
        @Path("id") id:String
    ): MoveInfo

    @GET("item/{id}")
    suspend fun getItem(
        @Path("id") id:String
    ): ItemInfo
    @GET("item-pocket/{id}")
    suspend fun getItemPocket(
        @Path("id") id:String
    ): PocketInfo
}
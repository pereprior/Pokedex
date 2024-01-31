package com.example.pokedex2.data.sources.local.file

import android.app.Application
import android.content.Context
import com.example.pokedex2.data.sources.dto.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.list.PokemonListDTO
import com.example.pokedex2.domain.repositories.IFileDataSource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javax.inject.Inject

class PokemonFileDataSource @Inject constructor(application: Application) : IFileDataSource {

    private val context: Context = application.applicationContext
    override fun obtainDetailsFromJson(dataName: String): PokemonDetailDTO {
        val jsonFile = context.assets.open("ditto.json").bufferedReader().use { it.readText() }
        val gson: Gson = GsonBuilder().create()
        return gson.fromJson(jsonFile, PokemonDetailDTO::class.java)
    }

    override fun obtainListFromJson(data: String): PokemonListDTO {
        val jsonFile = context.assets.open("pokemon.json").bufferedReader().use { it.readText() }
        val gson: Gson = GsonBuilder().create()
        return gson.fromJson(jsonFile, PokemonListDTO::class.java)
    }
}
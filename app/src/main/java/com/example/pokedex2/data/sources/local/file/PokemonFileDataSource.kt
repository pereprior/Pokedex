package com.example.pokedex2.data.sources.local.file

import android.app.Application
import android.content.Context
import com.example.pokedex2.data.sources.dto.pokemon.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.pokemon.list.PokemonListDTO
import com.example.pokedex2.domain.repositories.IFileDataSource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javax.inject.Inject

class PokemonFileDataSource @Inject constructor(application: Application) : IFileDataSource {

    private val context: Context = application.applicationContext

    // Obtenemos los datos de un pokemon especifico desde el json
    override fun obtainDetailsFromJson(dataName: String): PokemonDetailDTO {
        val jokerFile = "imposter" // He puesto a ditto ya que no me ha dado tiempo a poner todos los json, pero esto en la aplicacion real no estaria
        val jsonFile = context.assets.open("$jokerFile.json").bufferedReader().use { it.readText() }
        val gson: Gson = GsonBuilder().create()
        return gson.fromJson(jsonFile, PokemonDetailDTO::class.java)
    }

    // Obtenemos la lista de los pokemon desde el json
    override fun obtainListFromJson(data: String): PokemonListDTO {
        val jsonFile = context.assets.open("$data.json").bufferedReader().use { it.readText() }
        val gson: Gson = GsonBuilder().create()
        return gson.fromJson(jsonFile, PokemonListDTO::class.java)
    }
}
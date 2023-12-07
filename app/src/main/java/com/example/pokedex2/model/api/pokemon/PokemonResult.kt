package com.example.pokedex2.model.api.pokemon

import com.squareup.moshi.Json

data class PokemonResult(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)
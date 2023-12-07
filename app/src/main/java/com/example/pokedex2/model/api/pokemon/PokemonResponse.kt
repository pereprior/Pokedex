package com.example.pokedex2.model.api.pokemon

import com.squareup.moshi.Json

data class PokemonResponse(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "previous")
    val previous: Any,
    @Json(name = "results")
    val results: List<PokemonResult>
)
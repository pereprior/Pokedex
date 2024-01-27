package com.example.pokedex2.data.sources.remote.dto.list

import com.squareup.moshi.Json

data class PokemonListDTO(
    @field:Json(name = "count")
    val count: Int,

    @field:Json(name = "next")
    val next: String,

    @field:Json(name = "previous")
    val previous: Any,

    @field:Json(name = "results")
    var results: List<Results>
)
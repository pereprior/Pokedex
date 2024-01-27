package com.example.pokedex2.data.sources.remote.dto.detail

import com.squareup.moshi.Json

data class OfficialArtwork(
    @field:Json(name = "front_default")
    val frontDefault: String,

    @field:Json(name = "front_shiny")
    val frontShiny: String
)
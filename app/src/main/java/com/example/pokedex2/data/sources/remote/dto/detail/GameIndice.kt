package com.example.pokedex2.data.sources.remote.dto.detail

import com.squareup.moshi.Json

data class GameIndice(
    @field:Json(name = "game_index")
    val gameIndex: Int,

    @field:Json(name = "version")
    val version: Version
)
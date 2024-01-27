package com.example.pokedex2.data.sources.remote.dto.detail

import com.squareup.moshi.Json

data class Other(
    @field:Json(name = "dream_world")
    val dreamWorld: DreamWorld,

    @field:Json(name = "home")
    val home: Home,

    @field:Json(name = "official")
    val official: OfficialArtwork,

    @field:Json(name = "showdown")
    val showdown: Showdown
)
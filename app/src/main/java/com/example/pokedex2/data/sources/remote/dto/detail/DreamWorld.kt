package com.example.pokedex2.data.sources.remote.dto.detail

import com.squareup.moshi.Json

data class DreamWorld(
    @field:Json(name = "front_default")
    val frontDefault: String,

    @field:Json(name = "front_female")
    val frontFemale: Any
)
package com.example.pokedex2.data.sources.remote.dto.detail

import com.squareup.moshi.Json


data class Stat(
    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "url")
    val url: String
)
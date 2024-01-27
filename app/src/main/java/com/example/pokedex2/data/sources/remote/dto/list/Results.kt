package com.example.pokedex2.data.sources.remote.dto.list

import com.squareup.moshi.Json


data class Results(
    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "url")
    val url: String
)
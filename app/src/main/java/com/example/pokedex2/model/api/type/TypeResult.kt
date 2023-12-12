package com.example.pokedex2.model.api.type

import com.squareup.moshi.Json

data class TypeResult(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)
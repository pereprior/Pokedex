package com.example.pokedex2.model.api.type

import com.squareup.moshi.Json

data class TypeResponse(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: Any,
    @Json(name = "previous")
    val previous: Any,
    @Json(name = "results")
    val results: List<TypeResult>
)
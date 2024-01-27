package com.example.pokedex2.data.sources.remote.dto.detail

import com.squareup.moshi.Json

data class TypeDTO(
    @field:Json(name = "slot")
    val slot: Int,

    @field:Json(name = "type")
    val type: Type
)
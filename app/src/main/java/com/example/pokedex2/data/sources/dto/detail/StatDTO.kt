package com.example.pokedex2.data.sources.dto.detail

import com.squareup.moshi.Json

data class StatDTO(
    @field:Json(name = "base_stat")
    val baseStat: Int,

    @field:Json(name = "effort")
    val effort: Int,

    @field:Json(name = "stat")
    val stat: Stat
)
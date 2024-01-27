package com.example.pokedex2.data.sources.remote.dto.detail

import com.squareup.moshi.Json

data class AbilityDTO(
    @field:Json(name = "ability")
    val ability: Ability,

    @field:Json(name = "is_hidden")
    val isHidden: Boolean,

    @field:Json(name = "slot")
    val slot: Int
)
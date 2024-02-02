package com.example.pokedex2.data.sources.dto.detail

import com.google.gson.annotations.SerializedName

data class AbilityDTO(
    @SerializedName("ability")
    val ability: Ability,

    @SerializedName("is_hidden")
    val isHidden: Boolean,

    @SerializedName("slot")
    val slot: Int
)
package com.example.pokedex2.data.sources.dto.pokemon.detail

import com.google.gson.annotations.SerializedName

data class StatDTO(
    @SerializedName("base_stat")
    val baseStat: Int,

    @SerializedName("effort")
    val effort: Int,

    @SerializedName("stat")
    val stat: Stat
)
package com.example.pokedex2.data.sources.remote.dto.list

import com.google.gson.annotations.SerializedName

data class PokemonListDTO(
    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("previous")
    val previous: Any,

    @SerializedName("results")
    var results: List<Results>
)
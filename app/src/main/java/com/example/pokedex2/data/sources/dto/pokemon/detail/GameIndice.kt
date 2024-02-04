package com.example.pokedex2.data.sources.dto.pokemon.detail

import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    val gameIndex: Int,

    @SerializedName("version")
    val version: Version
)
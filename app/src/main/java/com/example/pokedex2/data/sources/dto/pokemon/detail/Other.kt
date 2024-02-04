package com.example.pokedex2.data.sources.dto.pokemon.detail

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld,

    @SerializedName("home")
    val home: Home,

    @SerializedName("official")
    val official: OfficialArtwork,

    @SerializedName("showdown")
    val showdown: Showdown
)
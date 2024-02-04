package com.example.pokedex2.data.sources.dto.pokemon.detail

import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
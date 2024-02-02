package com.example.pokedex2.data.sources.dto.list

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
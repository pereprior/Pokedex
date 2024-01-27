package com.example.pokedex2.data.sources.remote.dto.detail

import com.google.gson.annotations.SerializedName

data class VersionGroup(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
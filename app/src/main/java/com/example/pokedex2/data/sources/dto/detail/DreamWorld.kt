package com.example.pokedex2.data.sources.dto.detail

import com.google.gson.annotations.SerializedName

data class DreamWorld(
    @SerializedName("front_default")
    val frontDefault: String,

    @SerializedName("front_female")
    val frontFemale: Any
)
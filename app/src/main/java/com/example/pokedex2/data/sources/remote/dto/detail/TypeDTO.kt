package com.example.pokedex2.data.sources.remote.dto.detail

import com.google.gson.annotations.SerializedName

data class TypeDTO(
    @SerializedName("slot")
    val slot: Int,

    @SerializedName("type")
    val type: Type
)
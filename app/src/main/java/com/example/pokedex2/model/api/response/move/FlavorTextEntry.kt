package com.example.pokedex2.model.api.response.move

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class FlavorTextEntry(
    val flavor_text: String,
    val language: ResponsedUrlData,
    val version_group: ResponsedUrlData
)
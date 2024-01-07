package com.example.pokedex2.model.api.response.item

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class FlavorTextEntry(
    val language: ResponsedUrlData,
    val text: String,
    val version_group: ResponsedUrlData
)
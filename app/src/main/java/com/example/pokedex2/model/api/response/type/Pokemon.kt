package com.example.pokedex2.model.api.response.type

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class Pokemon(
    val pokemon: ResponsedUrlData,
    val slot: Int
)
package com.example.pokedex2.model.api.response.ability

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class Pokemon(
    val is_hidden: Boolean,
    val pokemon: ResponsedUrlData,
    val slot: Int
)
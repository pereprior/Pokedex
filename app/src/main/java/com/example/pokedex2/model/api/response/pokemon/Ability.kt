package com.example.pokedex2.model.api.response.pokemon

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class Ability(
    val ability: ResponsedUrlData,
    val is_hidden: Boolean,
    val slot: Int
)
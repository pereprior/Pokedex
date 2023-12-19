package com.example.pokedex2.model.api.response.pokemon

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: ResponsedUrlData
)
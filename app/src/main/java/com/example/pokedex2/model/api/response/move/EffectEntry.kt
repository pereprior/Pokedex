package com.example.pokedex2.model.api.response.move

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class EffectEntry(
    val effect: String,
    val language: ResponsedUrlData,
    val short_effect: String
)
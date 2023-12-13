package com.example.pokedex2.model.api.response

data class PokedexResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokedexData>
)
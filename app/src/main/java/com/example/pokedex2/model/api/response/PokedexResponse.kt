package com.example.pokedex2.model.api.response

data class PokedexResponse(
    val count: Int = 0,
    val next: String = "",
    val previous: Any = "",
    var results: List<ResponsedUrlData> = emptyList()
)
package com.example.pokedex2.data.sources.remote.dto.list

data class PokemonListDTO(
    val count: Int,
    val next: String,
    val previous: Any,
    var results: List<Results>
)
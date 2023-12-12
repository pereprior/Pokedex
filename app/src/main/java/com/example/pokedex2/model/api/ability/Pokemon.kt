package com.example.pokedex2.model.api.ability

data class Pokemon(
    val is_hidden: Boolean,
    val pokemon: PokemonX,
    val slot: Int
)
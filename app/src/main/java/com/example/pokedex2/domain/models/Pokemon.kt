package com.example.pokedex2.domain.models

data class Pokemon(
    val dexNumber: Int = 0,
    val name: String = "",
    val height: Float = 0.0f,
    val weight: Float = 0.0f,
    val stats: Map<String, Int> = emptyMap(),
    val abilities: Map<String, Boolean> = emptyMap(),
    val types: List<String> = emptyList(),
    val artwork: String = "",
    val sprites: List<Any> = emptyList()
)
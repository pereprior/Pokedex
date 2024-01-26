package com.example.pokedex2.domain.models

data class Pokemon(
    val dexNumber: Int,
    val name: String,
    val height: Float,
    val weight: Float,
    val stats: Map<String, Int>,
    val abilities: List<String>,
    val types: List<String>,
    val artwork: String,
    val sprites:List<Any>
)
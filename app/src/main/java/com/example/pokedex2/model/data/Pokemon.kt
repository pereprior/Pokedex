package com.example.pokedex2.model.data

data class Pokemon(
    val dexNumber:Int = 0,
    val name:String = "",
    val abilities: String = "",
    val baseExperience: String = "",
    val forms:String = "",
    val height:Float = 0f,
    val weight:Float = 0f,
    val sprites:List<String> = emptyList(),
    val stats:List<Int> = emptyList(),
    val types:List<Type> = emptyList()
)
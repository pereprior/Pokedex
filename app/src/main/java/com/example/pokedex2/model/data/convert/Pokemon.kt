package com.example.pokedex2.model.data.convert

import com.example.pokedex2.model.api.response.pokemon.PokemonInfo
import com.example.pokedex2.model.api.response.pokemon.Stat

class Pokemon(private val p:PokemonInfo = PokemonInfo()) {
    val dexNumber: Int = p.id

    val name: String = p.name

    val height: Float = p.height.toFloat()

    val weight: Float = p.weight.toFloat()

    val stats: List<Stat> = p.stats.map { it }

    val abilities = p.abilities

    val types = p.types

    val normalSprite: String = p.sprites.other.home.front_default

    val shinySprite: String = p.sprites.other.home.front_shiny

    val forms:List<String> = p.forms.map { it.name }

    var favorite = false
}
package com.example.pokedex2.model.data.convert

import com.example.pokedex2.model.api.response.pokemon.PokemonInfo
import com.example.pokedex2.model.api.response.pokemon.Stat

class Pokemon(private val p:PokemonInfo = PokemonInfo()) {
    val dexNumber: Int = p.id

    val name: String = p.name

    val height: Float = p.height/10f

    val weight: Float = p.weight/10f

    val stats: List<Stat> = p.stats.map { it }

    val abilities = p.abilities

    val types = p.types

    val normalSprite: String = p.sprites.other.home.front_default

    val forms:List<Any> = listOf(
        p.sprites.front_default,
        p.sprites.back_default,
        p.sprites.front_shiny,
        p.sprites.back_shiny,
        p.sprites.front_female,
        p.sprites.back_female,
        p.sprites.front_shiny_female,
        p.sprites.back_shiny_female
    )

    var favorite = false
}
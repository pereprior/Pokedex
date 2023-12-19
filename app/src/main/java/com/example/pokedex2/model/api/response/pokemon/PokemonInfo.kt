package com.example.pokedex2.model.api.response.pokemon

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class PokemonInfo(
    val abilities: List<Ability> = emptyList(),
    val base_experience: Int = 0,
    val forms: List<ResponsedUrlData> = emptyList(),
    val game_indices: List<GameIndice> = emptyList(),
    val height: Int = 0,
    val held_items: List<HeldItem> = emptyList(),
    val id: Int = 0,
    val is_default: Boolean = true,
    val location_area_encounters: String = "",
    val moves: List<Move> = emptyList(),
    val name: String = "",
    val order: Int = 0,
    val past_abilities: List<Any> = emptyList(),
    val past_types: List<Any> = emptyList(),
    val species: ResponsedUrlData = ResponsedUrlData(),
    val sprites: Sprites = Sprites("","","","","","","","", Other(DreamWorld("",""), Home("","","",""), OfficialArtwork("",""))),
    val stats: List<Stat> = emptyList(),
    val types: List<Type> = emptyList(),
    val weight: Int = 0
)
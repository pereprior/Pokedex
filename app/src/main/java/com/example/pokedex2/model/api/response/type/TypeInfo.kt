package com.example.pokedex2.model.api.response.type

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class TypeInfo(
    val damage_relations: DamageRelations = DamageRelations(emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), emptyList()),
    val game_indices: List<GameIndice> = emptyList(),
    val generation: ResponsedUrlData = ResponsedUrlData(),
    val id: Int = 0,
    val move_damage_class: ResponsedUrlData = ResponsedUrlData(),
    val moves: List<ResponsedUrlData> = emptyList(),
    val name: String = "",
    val names: List<Name> = emptyList(),
    val past_damage_relations: List<Any> = emptyList(),
    val pokemon: List<Pokemon> = emptyList()
)
package com.example.pokedex2.model.api.response.move

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class MoveInfo(
    val accuracy: Int = 0,
    val contest_combos: ContestCombos = ContestCombos(Normal("", emptyList()),Super("","")),
    val contest_effect: ContestEffect = ContestEffect(""),
    val contest_type: ResponsedUrlData = ResponsedUrlData(),
    val damage_class: ResponsedUrlData = ResponsedUrlData(),
    val effect_chance: Any = Any(),
    val effect_changes: List<Any> = listOf(),
    val effect_entries: List<EffectEntry> = listOf(),
    val flavor_text_entries: List<FlavorTextEntry> = listOf(),
    val generation: ResponsedUrlData = ResponsedUrlData(),
    val id: Int = 0,
    val learned_by_pokemon: List<ResponsedUrlData> = listOf(),
    val machines: List<Any> = listOf(),
    val meta: Meta = Meta(ResponsedUrlData(),0,ResponsedUrlData(),0,0,0,0,0,0,0,0,0),
    val name: String = "",
    val names: List<Name> = listOf(),
    val past_values: List<Any> = listOf(),
    val power: Int = 0,
    val pp: Int = 0,
    val priority: Int = 0,
    val stat_changes: List<Any> = listOf(),
    val super_contest_effect: ContestEffect = ContestEffect(""),
    //val target: Target = Target(),
    val type: ResponsedUrlData = ResponsedUrlData()
)

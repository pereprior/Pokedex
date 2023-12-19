package com.example.pokedex2.model.api.response.move

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class Meta(
    val ailment: ResponsedUrlData,
    val ailment_chance: Int,
    val category: ResponsedUrlData,
    val crit_rate: Int,
    val drain: Int,
    val flinch_chance: Int,
    val healing: Int,
    val max_hits: Any,
    val max_turns: Any,
    val min_hits: Any,
    val min_turns: Any,
    val stat_chance: Int
)
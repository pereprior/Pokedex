package com.example.pokedex2.model.api.response.ability

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class AbilityInfo(
    val effect_changes: List<EffectChange> = emptyList(),
    val effect_entries: List<EffectEntryX> = emptyList(),
    val flavor_text_entries: List<FlavorTextEntry> = emptyList(),
    val generation: ResponsedUrlData = ResponsedUrlData(),
    val id: Int = 0,
    val is_main_series: Boolean = false,
    val name: String = "",
    val names: List<Name> = emptyList(),
    val pokemon: List<Pokemon> = emptyList()
)

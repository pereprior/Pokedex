package com.example.pokedex2.model.api.response.item

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class ItemInfo(
    val attributes: List<ResponsedUrlData> = emptyList(),
    val baby_trigger_for: Any = Any(),
    val category: CategoryInfo = CategoryInfo(0, emptyList(),"", emptyList(),ResponsedUrlData()),
    val cost: Int = 0,
    val effect_entries: List<EffectEntry> = emptyList(),
    val flavor_text_entries: List<FlavorTextEntry> = emptyList(),
    val fling_effect: Any = Any(),
    val fling_power: Any = Any(),
    val game_indices: List<GameIndice> = emptyList(),
    val held_by_pokemon: List<Any> = emptyList(),
    val id: Int = 0,
    val machines: List<Any> = emptyList(),
    val name: String = "",
    val names: List<ResponsedUrlData> = emptyList(),
    val sprites: Sprites = Sprites("")
)

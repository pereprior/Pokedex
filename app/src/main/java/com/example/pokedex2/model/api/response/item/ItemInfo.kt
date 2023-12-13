package com.example.pokedex2.model.api.response.item

data class ItemInfo(
    val attributes: List<Attribute>,
    val baby_trigger_for: Any,
    val category: Category,
    val cost: Int,
    val effect_entries: List<EffectEntry>,
    val flavor_text_entries: List<FlavorTextEntry>,
    val fling_effect: Any,
    val fling_power: Any,
    val game_indices: List<GameIndice>,
    val held_by_pokemon: List<Any>,
    val id: Int,
    val machines: List<Any>,
    val name: String,
    val names: List<Name>,
    val sprites: Sprites
)
package com.example.pokedex2.model.api.move

data class Move(
    val accuracy: Int,
    val contest_combos: ContestCombos,
    val contest_effect: ContestEffect,
    val contest_type: ContestType,
    val damage_class: DamageClass,
    val effect_chance: Any,
    val effect_changes: List<Any>,
    val effect_entries: List<EffectEntry>,
    val flavor_text_entries: List<FlavorTextEntry>,
    val generation: Generation,
    val id: Int,
    val learned_by_pokemon: List<LearnedByPokemon>,
    val machines: List<Any>,
    val meta: Meta,
    val name: String,
    val names: List<Name>,
    val past_values: List<Any>,
    val power: Int,
    val pp: Int,
    val priority: Int,
    val stat_changes: List<Any>,
    val super_contest_effect: SuperContestEffect,
    val target: Target,
    val type: Type
)
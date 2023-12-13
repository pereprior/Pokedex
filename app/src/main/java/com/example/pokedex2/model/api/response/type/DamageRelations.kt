package com.example.pokedex2.model.api.response.type

data class DamageRelations(
    val double_damage_from: List<DoubleDamageFrom>,
    val double_damage_to: List<Any>,
    val half_damage_from: List<Any>,
    val half_damage_to: List<HalfDamageTo>,
    val no_damage_from: List<NoDamageFrom>,
    val no_damage_to: List<NoDamageTo>
)
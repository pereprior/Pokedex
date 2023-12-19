package com.example.pokedex2.model.api.response.type

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class DamageRelations(
    val double_damage_from: List<ResponsedUrlData>,
    val double_damage_to: List<ResponsedUrlData>,
    val half_damage_from: List<ResponsedUrlData>,
    val half_damage_to: List<ResponsedUrlData>,
    val no_damage_from: List<ResponsedUrlData>,
    val no_damage_to: List<ResponsedUrlData>
)
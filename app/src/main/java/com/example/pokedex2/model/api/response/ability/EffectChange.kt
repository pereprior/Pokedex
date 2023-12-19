package com.example.pokedex2.model.api.response.ability

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class EffectChange(
    val effect_entries: List<EffectEntry>,
    val version_group: ResponsedUrlData
)
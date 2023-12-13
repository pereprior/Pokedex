package com.example.pokedex2.model.api.response.ability

data class EffectChange(
    val effect_entries: List<EffectEntry>,
    val version_group: VersionGroup
)
package com.example.pokedex2.model.api.ability

data class EffectChange(
    val effect_entries: List<EffectEntry>,
    val version_group: VersionGroup
)
package com.example.pokedex2.model.api.response.move

data class FlavorTextEntry(
    val flavor_text: String,
    val language: Language,
    val version_group: VersionGroup
)
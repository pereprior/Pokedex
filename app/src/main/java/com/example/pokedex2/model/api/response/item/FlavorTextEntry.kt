package com.example.pokedex2.model.api.response.item

data class FlavorTextEntry(
    val language: Language,
    val text: String,
    val version_group: VersionGroup
)
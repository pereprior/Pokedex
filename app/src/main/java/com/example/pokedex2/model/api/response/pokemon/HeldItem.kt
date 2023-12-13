package com.example.pokedex2.model.api.response.pokemon

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)
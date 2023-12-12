package com.example.pokedex2.model.api.pokemon

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)
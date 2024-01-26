package com.example.pokedex2.data.sources.remote.dto.detail

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)
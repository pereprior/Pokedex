package com.example.pokedex2.model.api.response.pokemon

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class Move(
    val move: ResponsedUrlData,
    val version_group_details: List<VersionGroupDetail>
)
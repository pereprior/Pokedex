package com.example.pokedex2.model.api.response.pokemon

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: ResponsedUrlData,
    val version_group: ResponsedUrlData
)
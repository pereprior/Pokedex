package com.example.pokedex2.data.sources.dto.detail

import com.squareup.moshi.Json


data class VersionGroupDetail(
    @field:Json(name = "level_learned_at")
    val levelLearnedAt: Int,

    @field:Json(name = "move_learn_method")
    val moveLearnMethod: MoveLearnMethod,

    @field:Json(name = "version_group")
    val versionGroup: VersionGroup
)
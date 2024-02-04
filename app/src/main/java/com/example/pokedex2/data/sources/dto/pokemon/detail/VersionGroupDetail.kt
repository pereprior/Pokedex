package com.example.pokedex2.data.sources.dto.pokemon.detail

import com.google.gson.annotations.SerializedName

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int,

    @SerializedName("move_learn_method")
    val moveLearnMethod: MoveLearnMethod,

    @SerializedName("version_group")
    val versionGroup: VersionGroup
)
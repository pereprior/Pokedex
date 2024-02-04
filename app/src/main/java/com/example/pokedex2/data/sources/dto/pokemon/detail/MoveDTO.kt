package com.example.pokedex2.data.sources.dto.pokemon.detail

import com.google.gson.annotations.SerializedName

data class MoveDTO(
    @SerializedName("move")
    val move: Move,

    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)
package com.example.pokedex2.data.sources.dto.detail

import com.squareup.moshi.Json

data class MoveDTO(
    @field:Json(name = "move")
    val move: Move,

    @field:Json(name = "version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)
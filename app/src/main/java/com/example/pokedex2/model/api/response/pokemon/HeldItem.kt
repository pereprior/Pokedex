package com.example.pokedex2.model.api.response.pokemon

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class HeldItem(
    val item: ResponsedUrlData,
    val version_details: List<VersionDetail>
)
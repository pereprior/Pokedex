package com.example.pokedex2.model.api.response.item

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class PocketInfo(
    val categories: List<ResponsedUrlData>,
    val id: Int,
    val name: String,
    val names: List<Name>
)
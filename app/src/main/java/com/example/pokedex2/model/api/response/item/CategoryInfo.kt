package com.example.pokedex2.model.api.response.item

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class CategoryInfo(
    val id: Int,
    val items: List<ResponsedUrlData>,
    val name: String,
    val names: List<NameX>,
    val pocket: ResponsedUrlData
)
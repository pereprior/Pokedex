package com.example.pokedex2.model.api.response.move

import com.example.pokedex2.model.api.response.ResponsedUrlData

data class Normal(
    val use_after: Any,
    val use_before: List<ResponsedUrlData>
)
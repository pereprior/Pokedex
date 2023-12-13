package com.example.pokedex2.model.api.response.move

data class Normal(
    val use_after: Any,
    val use_before: List<UseBefore>
)
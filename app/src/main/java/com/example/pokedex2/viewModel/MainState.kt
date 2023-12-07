package com.example.pokedex2.viewModel

import com.example.pokedex2.model.data.Pokemon

data class MainState(
    val isLoading: Boolean = false,
    val pokemons: List<Pokemon> = emptyList()
)
package com.example.pokedex2.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.model.api.IPokedexApi
import com.example.pokedex2.model.api.PokedexRepository
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val repository: PokedexRepository = PokedexRepository(IPokedexApi.instance)
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.getPokemons().onSuccess {
                state = state.copy(
                    pokemons = it
                )
            }.onFailure {

            }
            state = state.copy(isLoading = false)
        }
    }
}
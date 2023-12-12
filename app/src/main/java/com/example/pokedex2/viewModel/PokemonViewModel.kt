package com.example.pokedex2.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.model.api.IPokedexApi
import com.example.pokedex2.model.PokedexRepository
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val repository: PokedexRepository = PokedexRepository(IPokedexApi.instance)
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    fun getPokemon(dexNumber:Int){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.getPokemonInfo(dexNumber).onSuccess {
                state = state.copy(
                    pokemon = it
                )
            }.onFailure { /* TODO */}
            state = state.copy(isLoading = false)
        }
    }

    fun getType(id:Int){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.getTypes(id).onSuccess {
                state = state.copy(
                    type = it
                )
            }.onFailure { /* TODO */}
            state = state.copy(isLoading = false)
        }
    }

    fun getAbility(id:Int){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.getAbility(id).onSuccess {
                state = state.copy(
                    ability = it
                )
            }.onFailure { /* TODO */}
            state = state.copy(isLoading = false)
        }
    }
}
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
    var state by mutableStateOf(MainState(false,""))
        private set

    fun getAllData(item:String){
        state = state.copy(isLoading = true)

        viewModelScope.launch {
            repository.getGenericData(item).onSuccess {
                state = state.copy(
                    data = it
                )
            }.onFailure { /* TODO */}
        }

        state = state.copy(isLoading = false)
    }

    fun getPokemon(id:String){
        state = state.copy(isLoading = true)

        viewModelScope.launch {
            repository.getPokemonInfo(id).onSuccess {
                state = state.copy(
                    data = it
                )
            }.onFailure { /* TODO */}
        }

        state = state.copy(isLoading = false)
    }

    fun getType(id:String){
        state = state.copy(isLoading = true)

        viewModelScope.launch {
            repository.getTypes(id).onSuccess {
                state = state.copy(
                    data = it
                )
            }.onFailure { /* TODO */}
        }

        state = state.copy(isLoading = false)
    }

    fun getAbility(id:String){
        state = state.copy(isLoading = true)

        viewModelScope.launch {
            repository.getAbility(id).onSuccess {
                state = state.copy(
                    data = it
                )
            }.onFailure { /* TODO */}
        }

        state = state.copy(isLoading = false)
    }
}
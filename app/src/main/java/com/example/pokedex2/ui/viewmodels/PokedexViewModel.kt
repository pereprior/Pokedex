package com.example.pokedex2.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.model.api.PokedexRepository
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.model.data.convert.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val repository: PokedexRepository
) : ViewModel() {

    private var _pokemonList = MutableLiveData<PokedexResponse>()
    private var _pokemon = MutableLiveData<Pokemon>()

    val pokemonList: LiveData<PokedexResponse> = _pokemonList
    val selectedPokemon: LiveData<Pokemon> = _pokemon

    fun getPokemonList() {
        viewModelScope.launch {

            repository.getGenericData("pokemon").onSuccess {
                _pokemonList.value = it
            }.onFailure { /* TODO: json read */ }

        }
    }

    fun getPokemon(name:String) {
        viewModelScope.launch {

            repository.getPokemonInfo(name).onSuccess {
                _pokemon.value = Pokemon(it)
            }.onFailure { /* TODO */ }

        }
    }
}
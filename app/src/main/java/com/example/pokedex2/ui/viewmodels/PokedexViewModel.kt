package com.example.pokedex2.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.domain.models.Pokemon
import com.example.pokedex2.domain.usecases.GetPokemonDetailsUseCase
import com.example.pokedex2.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : ViewModel() {

    private var _pokemonList = MutableLiveData<List<String>>()
    private var _pokemon = MutableLiveData<Pokemon>()

    val pokemonList: LiveData<List<String>> = _pokemonList
    val selectedPokemon: LiveData<Pokemon> = _pokemon

    fun getPokemonList() {
        viewModelScope.launch {

            _pokemonList.value = getPokemonListUseCase.execute()

        }
    }

    fun getPokemon(name:String) {
        viewModelScope.launch {

            _pokemon.value = getPokemonDetailsUseCase.execute(name)

        }
    }
}

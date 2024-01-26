package com.example.pokedex2.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.data.sources.remote.dto.list.PokemonListDTO
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

    private var _pokemonList = MutableLiveData<PokemonListDTO>()
    private var _pokemon = MutableLiveData<Pokemon>()

    val pokemonList: LiveData<PokemonListDTO> = _pokemonList
    val selectedPokemon: LiveData<Pokemon> = _pokemon

    fun getPokemonList() {
        viewModelScope.launch {
            val result = getPokemonListUseCase.execute()
            if (result.isSuccess) {
                _pokemonList.value = result.getOrNull()
            } else {
                // TODO JSON IMPLEMENTATION
            }
        }
    }

    fun getPokemon(name:String) {
        viewModelScope.launch {
            val result = getPokemonDetailsUseCase.execute(name)
            if (result.isSuccess) {
                _pokemon.value = Pokemon(result.getOrNull())
            } else {
                // TODO JSON IMPLEMENTATION
            }
        }
    }
}

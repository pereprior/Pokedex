package com.example.pokedex2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.model.api.IPokedexApi
import com.example.pokedex2.model.api.PokedexRepository
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.model.data.convert.Ability
import com.example.pokedex2.model.data.convert.Item
import com.example.pokedex2.model.data.convert.Move
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.model.data.convert.Type
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val repository: PokedexRepository = PokedexRepository(IPokedexApi.instance)
) : ViewModel() {

    private var _pokemonList = MutableLiveData<PokedexResponse>()
    private var _typeList = MutableLiveData<PokedexResponse>()
    private var _moveList = MutableLiveData<PokedexResponse>()
    private var _itemList = MutableLiveData<PokedexResponse>()
    private var _abilityList = MutableLiveData<PokedexResponse>()
    private var _pokemon = MutableLiveData<Pokemon>()
    private var _type = MutableLiveData<Type>()
    private var _move = MutableLiveData<Move>()
    private var _item = MutableLiveData<Item>()
    private var _ability = MutableLiveData<Ability>()
    private var _favorites = MutableLiveData<ArrayList<Pokemon>>(ArrayList())

    val pokemonList: LiveData<PokedexResponse> = _pokemonList
    val moveList: LiveData<PokedexResponse> = _moveList
    val itemList: LiveData<PokedexResponse> = _itemList
    val typeList: LiveData<PokedexResponse> = _typeList
    val abilityList: LiveData<PokedexResponse> = _abilityList
    val selectedPokemon: LiveData<Pokemon> = _pokemon
    val selectedType: LiveData<Type> = _type
    val selectedMove: LiveData<Move> = _move
    val selectedItem: LiveData<Item> = _item
    val selectedAbility: LiveData<Ability> = _ability
    val favorites: LiveData<ArrayList<Pokemon>> = _favorites

    fun getPokemon(name:String) {
        viewModelScope.launch {

            repository.getPokemonInfo(name).onSuccess {
                _pokemon.value = Pokemon(it)
            }.onFailure { /* TODO */ }

        }
    }

    fun getPokemonList() {
        viewModelScope.launch {

            repository.getGenericData("pokemon").onSuccess {
                _pokemonList.value = it
            }.onFailure { /* TODO */ }

        }
    }

    fun getType(name:String) {
        viewModelScope.launch {

            repository.getTypes(name).onSuccess {
                _type.value = Type(it)
            }.onFailure { /* TODO */ }

        }
    }

    fun getTypeList() {
        viewModelScope.launch {
            repository.getGenericData("type").onSuccess {
                _typeList.value = it
            }.onFailure { /* TODO */ }
        }
    }

    fun getMove(name:String) {
        viewModelScope.launch {

            repository.getMove(name).onSuccess {
                _move.value = Move(it)
            }.onFailure { /* TODO */ }

        }
    }

    fun getMoveList() {
        viewModelScope.launch {
            repository.getGenericData("move").onSuccess {
                _moveList.value = it
            }.onFailure { /* TODO */ }
        }
    }

    fun getItem(name:String) {
        viewModelScope.launch {

            repository.getItem(name).onSuccess {

                _item.value = Item(it)
            }.onFailure { /* TODO */ }

        }
    }

    fun getItemList(category:String) {
        viewModelScope.launch {
            repository.getGenericData("item").onSuccess {

                repository.getItemsCategory(category).onSuccess {

                }.onFailure { /* TODO */ }
                _itemList.value = it

            }.onFailure { /* TODO */ }
        }
    }

    fun getAbility(name:String) {
        viewModelScope.launch {

            repository.getAbility(name).onSuccess {
                _ability.value = Ability(it)
            }.onFailure { /* TODO */ }

        }
    }

    fun getAbilityList() {
        viewModelScope.launch {
            repository.getGenericData("ability").onSuccess {
                _abilityList.value = it
            }.onFailure { /* TODO */ }
        }
    }

}
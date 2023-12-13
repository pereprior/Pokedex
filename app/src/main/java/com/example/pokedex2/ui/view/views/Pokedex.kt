package com.example.pokedex2.ui.view.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.viewModel.PokemonViewModel

@Composable
fun Pokedex(vm: PokemonViewModel) {
    /**
     * PARA LLAMAR LA INFORMACION DE UN POKEMON EN ESPECIFICO:
     * vm.getPokemon(888)
     * EL NUMERO PONES EL SUYO DE LA POKEDEX
     *
     * PARA LLAMAR A TODOS LOS POKEMON A LA VEZ:
     * vm.getAllData("pokemon")
     *
     * ES EN TODOS IGUAL, CUALQUIER DUDA O FALLO QUE ENCUENTRES AVISAME ;)
     */

    vm.getAllData("pokemon")
    val state = vm.state

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    if (state.data is PokedexResponse) {
        val pokemonList = state.data.results

        if (pokemonList.isNotEmpty()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(pokemonList){
                    Text(text = it.name)
                }
            }
        }
    }
}
package com.example.pokedex2.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pokedex2.viewModel.PokemonViewModel

@Composable
fun Pruebas(vm:PokemonViewModel) {
    vm.getPokemon(567)
    vm.getType(16)
    vm.getAbility(200)
    val state = vm.state

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    Column {
        Text(text = state.pokemon.name)
        Text(text = state.type.name)
        Text(text = state.ability.name)
    }

    /*if (state.pokemons.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.pokemons){
                Text(text = it.name)
            }
        }
    }*/
}
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
fun Habilidades(vm: PokemonViewModel) {
    vm.getAllData("ability")
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
        val abilityList = state.data.results

        if (abilityList.isNotEmpty()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(abilityList){
                    Text(text = it.name)
                }
            }
        }
    }
}
package com.example.pokedex2.ui.view.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.viewModel.PokemonViewModel

@Composable
fun PokemonView(
    vm: PokemonViewModel,
    selectedPokemon: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getPokemon(selectedPokemon!!)
    }

    val p by vm.selectedPokemon.observeAsState(initial = Pokemon())

    Text(text = p.name)
}
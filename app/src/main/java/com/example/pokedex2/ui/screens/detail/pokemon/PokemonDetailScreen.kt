package com.example.pokedex2.ui.screens.detail.pokemon

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.domain.models.Pokemon
import com.example.pokedex2.ui.components.charging.WaitCircle
import com.example.pokedex2.ui.screens.detail.pokemon.body.PokemonBodyView
import com.example.pokedex2.ui.screens.detail.pokemon.head.PokemonHeaderView
import com.example.pokedex2.ui.viewmodels.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonDetailScreen(
    vm: PokedexViewModel,
    selectedPokemon: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getPokemon(selectedPokemon!!)
    }

    val pokemonData by vm.selectedPokemon.observeAsState(initial = Pokemon())

    if (pokemonData.name.isEmpty()) {
        WaitCircle()
    } else {
        LazyColumn(
            modifier = Modifier.background(MaterialTheme.colorScheme.secondary),
            content = {
                item {
                    PokemonHeaderView(pokemonData, navController)
                    Spacer(modifier = Modifier.padding(4.dp))
                    PokemonBodyView(pokemonData)
                }
            }
        )
    }
}
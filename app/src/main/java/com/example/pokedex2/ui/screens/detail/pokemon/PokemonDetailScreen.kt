package com.example.pokedex2.ui.screens.detail.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.constants.values.LOW_PADDING_VALUE
import com.example.pokedex2.domain.models.Pokemon
import com.example.pokedex2.ui.components.utils.loading.WaitScreen
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.PokemonBodyView
import com.example.pokedex2.ui.screens.detail.pokemon.components.head.PokemonHeaderView
import com.example.pokedex2.ui.viewmodels.PokemonViewModel

@Composable
fun PokemonDetailScreen(
    pokemonViewModel: PokemonViewModel,
    selectedPokemon: String?,
    navController: NavHostController
) {
    // Cargo los datos del pokemon seleccionado desde el view model
    LaunchedEffect(Unit) {
        pokemonViewModel.getPokemon(selectedPokemon!!)
    }

    val pokemonDetailData by pokemonViewModel.selectedPokemon.observeAsState(initial = Pokemon())

    // Muestre la pantalla de carga mientras los datos del pokemon esten vacios
    if (pokemonDetailData.name.isEmpty()) {
        WaitScreen()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.secondary
                )
        ) {
            // Vista de color
            PokemonHeaderView(
                pokemonData = pokemonDetailData,
                navController = navController
            )

            Spacer(modifier = Modifier.padding(LOW_PADDING_VALUE.dp))

            // Vista sobre el fondo grisaceo
            PokemonBodyView(
                pokemonData = pokemonDetailData
            )
        }
    }
}
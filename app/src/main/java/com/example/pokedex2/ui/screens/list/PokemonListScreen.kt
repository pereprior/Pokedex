package com.example.pokedex2.ui.screens.list

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.constants.POKEMON_NAVIGATION_PATH
import com.example.pokedex2.ui.components.mainbar.search.SearchBarScreen
import com.example.pokedex2.ui.components.utils.loading.WaitScreen
import com.example.pokedex2.ui.viewmodels.PokemonViewModel

@Composable
fun PokemonListScreen(
    pokemonViewModel: PokemonViewModel,
    navController: NavHostController,
    drawerState: DrawerState
) {
    // Cargar la lista de pokemon desde el view model
    LaunchedEffect(Unit) {
        pokemonViewModel.getPokemonList()
    }

    val pokemonListData by pokemonViewModel.pokemonList.observeAsState(initial = emptyList())

    // Que muestre la pantalla de carga mientras se carga la lista de pokemon
    if (pokemonListData.isEmpty()) {
        WaitScreen()
    } else {
        SearchBarScreen(
            navController = navController,
            drawerState = drawerState,
            dataList = pokemonListData,
            packageRoute = POKEMON_NAVIGATION_PATH
        )
    }
}
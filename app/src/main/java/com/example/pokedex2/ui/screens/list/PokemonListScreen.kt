package com.example.pokedex2.ui.screens.list

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.ui.components.bar.search.SearchBarScreen
import com.example.pokedex2.ui.components.charging.WaitCircle
import com.example.pokedex2.ui.viewmodels.PokedexViewModel

@Composable
fun PokemonListScreen(
    vm: PokedexViewModel,
    navController: NavHostController,
    drawerState: DrawerState
) {
    LaunchedEffect(Unit) {
        vm.getPokemonList()
    }

    val dataList by vm.pokemonList.observeAsState(initial = PokedexResponse())
    val pokemonList = dataList.results

    if (pokemonList.isEmpty()) {
        WaitCircle()
    } else {
        SearchBarScreen(
            navController = navController,
            drawerState = drawerState,
            data = pokemonList,
            componentRoute = "PokemonView"
        )
    }
}
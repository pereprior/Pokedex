package com.example.pokedex2.ui.views.list

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.nav.search.SubMenu
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Pokedex(vm: PokedexViewModel, navController: NavHostController, drawerState: DrawerState) {
    LaunchedEffect(Unit) {
        vm.getPokemonList()
    }

    val dataList by vm.pokemonList.observeAsState(initial = PokedexResponse())
    val pokemonList = dataList.results

    if (pokemonList.isEmpty()) {
        WaitCircle("mainMenu", navController)
    } else {
        SubMenu(
            navController = navController,
            drawerState = drawerState,
            data = pokemonList,
            route = "PokemonView"
        )
    }
}
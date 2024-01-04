package com.example.pokedex2.ui.views.list

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

@Composable
fun Objetos(
    vm: PokedexViewModel,
    navController: NavHostController,
    drawerState: DrawerState
) {
    LaunchedEffect(Unit) {
        vm.getItemList()
    }

    val dataList by vm.itemList.observeAsState(initial = PokedexResponse())
    val itemList = dataList.results

    if (itemList.isEmpty()) {
        WaitCircle()
    } else {
        SubMenu(
            navController = navController,
            drawerState = drawerState,
            data = itemList,
            route = "ItemView"
        )
    }
}
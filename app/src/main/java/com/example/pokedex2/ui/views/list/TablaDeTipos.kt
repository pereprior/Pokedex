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
fun TablaDeTipos(vm: PokedexViewModel, drawerState: DrawerState, navController: NavHostController) {
    LaunchedEffect(Unit) {
        vm.getTypeList()
    }

    val dataList by vm.typeList.observeAsState(initial = PokedexResponse())
    val typeList = dataList.results

    if (typeList.isEmpty()) {
        WaitCircle()
    } else {
        SubMenu(
            navController = navController,
            drawerState = drawerState,
            data = typeList,
            route = "TypeView"
        )
    }
}
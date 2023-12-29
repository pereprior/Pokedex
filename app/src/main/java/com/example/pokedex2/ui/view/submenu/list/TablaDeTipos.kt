package com.example.pokedex2.ui.view.submenu.list

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.ui.view.submenu.MySearchBar
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TablaDeTipos(vm: PokedexViewModel, drawerState: DrawerState, navController: NavHostController) {
    LaunchedEffect(Unit) {
        vm.getTypeList()
    }

    val dataList by vm.typeList.observeAsState(initial = PokedexResponse())
    val typeList = dataList.results

    MySearchBar(
        navController = navController,
        drawerState = drawerState,
        data = typeList,
        route = "TypeView"
    )
}
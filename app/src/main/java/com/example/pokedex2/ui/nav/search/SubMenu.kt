package com.example.pokedex2.ui.nav.search

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.api.response.ResponsedUrlData
import com.example.pokedex2.ui.NotFoundDialog
import com.example.pokedex2.viewModel.SearchBarViewModel

@Composable
fun SubMenu(navController: NavHostController, drawerState: DrawerState, data: List<ResponsedUrlData>, route: String){
    val vm = SearchBarViewModel()
    val query: String by vm.query.observeAsState(initial = "")
    val filteredData: List<String> by vm.filteredList.observeAsState(initial = emptyList())
    val isOpenDialog: Boolean by vm.openDialog.observeAsState(initial = false)

    vm.setDataList(data,query)

    MySearchBar(query, vm, filteredData, navController, route, drawerState)

    if (isOpenDialog) {
        NotFoundDialog(onDismissRequest = { vm.setOpenDialog(false) })
    }
}
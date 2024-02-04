package com.example.pokedex2.ui.screens.list

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.constants.messages.ERROR_404_DESCRIPTION
import com.example.pokedex2.constants.messages.ERROR_404_TITLE
import com.example.pokedex2.ui.components.mainbar.search.PokedexSearchBar
import com.example.pokedex2.ui.components.utils.dialog.NotFoundDialog
import com.example.pokedex2.ui.viewmodels.SearchBarViewModel

@Composable
fun SearchBarScreen(
    navController: NavHostController,
    drawerState: DrawerState,
    dataList: List<String>,
    route: String
) {
    val searchBarViewModel = SearchBarViewModel()
    val query: String by searchBarViewModel.query.observeAsState(initial = "")
    val filteredData: List<String> by searchBarViewModel.filteredList.observeAsState(initial = emptyList())
    val isOpenDialog: Boolean by searchBarViewModel.openDialog.observeAsState(initial = false)

    searchBarViewModel.setDataList(dataList,query)

    // Pantalla generica que se muestra en cada una de las listas
    PokedexSearchBar(
        query = query,
        searchBarViewModel = searchBarViewModel,
        filteredDataList = filteredData,
        navController = navController,
        route = route,
        drawerState = drawerState
    )

    // Si el usuario busca un objeto que no existe saldra un mensaje de error
    if (isOpenDialog) {
        NotFoundDialog(
            onDismissRequest = { searchBarViewModel.setOpenDialog(false) },
            title = ERROR_404_TITLE,
            description = ERROR_404_DESCRIPTION
        )
    }
}
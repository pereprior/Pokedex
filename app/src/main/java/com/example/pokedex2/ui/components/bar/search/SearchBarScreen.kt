package com.example.pokedex2.ui.components.bar.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pokedex2.ui.components.error.dialog.NotFoundDialog
import com.example.pokedex2.ui.components.icons.MenuIcon
import com.example.pokedex2.ui.viewmodels.SearchBarViewModel

@Composable
fun SearchBarScreen(
    navController: NavHostController,
    drawerState: DrawerState,
    data: List<String>,
    packageRoute: String
) {
    val searchBarViewModel = SearchBarViewModel()
    val query: String by searchBarViewModel.query.observeAsState(initial = "")
    val filteredData: List<String> by searchBarViewModel.filteredList.observeAsState(initial = emptyList())
    val isOpenDialog: Boolean by searchBarViewModel.openDialog.observeAsState(initial = false)

    searchBarViewModel.setDataList(data,query)

    GenericSearchBar(
        query = query,
        searchBarViewModel = searchBarViewModel,
        filteredDataList = filteredData,
        navController = navController,
        packageRoute = packageRoute,
        drawerState = drawerState
    )

    if (isOpenDialog) {
        NotFoundDialog(onDismissRequest = { searchBarViewModel.setOpenDialog(false) })
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun GenericSearchBar(
    query: String,
    searchBarViewModel: SearchBarViewModel,
    filteredDataList: List<String>,
    navController: NavHostController,
    packageRoute: String,
    drawerState: DrawerState
) {
    val active: Boolean by searchBarViewModel.isActive.observeAsState(initial = true)

    SearchBar(
        query = query,
        onQueryChange = {
            searchBarViewModel.setQuery(it)
        },
        onSearch = {
            if (filteredDataList.any { it.equals(query, ignoreCase = true) }) {
                navController.navigate("$packageRoute/${query.lowercase()}")
                searchBarViewModel.setActive(false)
            } else {
                searchBarViewModel.setOpenDialog(true)
            }
        },
        active = active,
        onActiveChange = {
            searchBarViewModel.setActive(it)
        },
        leadingIcon = {
            MenuIcon(drawerState)
        },
        placeholder = {
            Text(text = "Search")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "")
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredDataList) {
                SarchBarOptionButton(navController, it, packageRoute)
            }
        }
    }
}
package com.example.pokedex2.ui.components.nav.search

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
import com.example.pokedex2.ui.components.nav.MenuIcon
import com.example.pokedex2.ui.viewmodels.SearchBarViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MySearchBar(
    query: String,
    vm: SearchBarViewModel,
    filteredData: List<String>,
    navController: NavHostController,
    route: String,
    drawerState: DrawerState
) {
    val active: Boolean by vm.isActive.observeAsState(initial = true)

    SearchBar(
        query = query,
        onQueryChange = { vm.setQuery(it) },
        onSearch = {
            if (filteredData.any { it.equals(query, ignoreCase = true) }) {
                navController.navigate("$route/${query.lowercase()}")
                vm.setActive(false)
            } else {
                vm.setOpenDialog(true)
            }
        },
        active = active,
        onActiveChange = { vm.setActive(it) },
        leadingIcon = {
            MenuIcon(drawerState)
        },
        placeholder = { Text(text = "Search") },
        trailingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "") }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredData) {
                DataButton(navController, it, route)
            }
        }
    }
}
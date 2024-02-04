package com.example.pokedex2.ui.components.mainbar.search

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
import androidx.navigation.NavHostController
import com.example.pokedex2.ui.components.utils.icons.MenuIcon
import com.example.pokedex2.ui.viewmodels.SearchBarViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PokedexSearchBar(
    query: String,
    searchBarViewModel: SearchBarViewModel,
    filteredDataList: List<String>,
    navController: NavHostController,
    route: String,
    drawerState: DrawerState
) {
    val active: Boolean by searchBarViewModel.isActive.observeAsState(initial = true)

    SearchBar(
        query = query,
        onQueryChange = {
            searchBarViewModel.setQuery(it)
        },
        onSearch = {
            // Comprobamos que en la lista existe un objeto igual que el que ha buscado el usuario
            if (filteredDataList.any { it.equals(query, ignoreCase = true) }) {
                // Con lowercase, el usuario puede buscar con mayusculas y minusculas como quiera
                navController.navigate("$route/${query.lowercase()}")
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
            // Icono que gestiona el menu drawer
            MenuIcon(drawerState)
        },
        placeholder = {
            Text(text = "Search")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "")
        }
    ) {
        LazyColumn {
            items(filteredDataList) {
                // Botones que contienen todos los datos de la api/json
                SarchBarOptionButton(navController, it, route)
            }
        }
    }
}
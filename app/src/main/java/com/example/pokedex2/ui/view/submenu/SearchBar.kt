package com.example.pokedex2.ui.view.submenu

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.model.api.response.ResponsedUrlData
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.capitalized
import com.example.pokedex2.ui.nav.MenuIcon
import com.example.pokedex2.viewModel.SearchBarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBar(navController: NavHostController, drawerState: DrawerState, data: List<ResponsedUrlData>, route: String){
    val vm = SearchBarViewModel()
    val query: String by vm.query.observeAsState(initial = "")
    val active: Boolean by vm.isActive.observeAsState(initial = true)
    val filteredData: List<String> by vm.filteredList.observeAsState(initial = emptyList())

    vm.setDataList(data,query)

    if (filteredData.isEmpty()) {
        WaitCircle()
    } else {
        SearchBar(
            query = query,
            onQueryChange = { vm.setQuery(it) },
            onSearch = {
                if (filteredData.any { it.equals(query, ignoreCase = true) }) {
                    navController.navigate("$route/${query.lowercase()}")
                    vm.setActive(false)
                } else {
                    /* TODO */
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
}

@Composable
private fun DataButton(navController: NavHostController, name: String, route: String) {
    Spacer(modifier = Modifier.padding(4.dp))
    Button(
        onClick = { navController.navigate("$route/$name") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = capitalized(name),
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
package com.example.pokedex2.ui.view.views.pokemon

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.pokedex2.model.api.response.ResponsedUrlData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBar(navController: NavHostController, pokemons: List<ResponsedUrlData>){
    val context = LocalContext.current
    var query by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    val filteredPokemon = pokemons.filter { it.name.contains(query, true) }

    var isSearching by remember { mutableStateOf(false) }

    Row (
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.clickable {
                isSearching = !isSearching
                if (!isSearching && query.isNotEmpty()) {
                    if (filteredPokemon.any { it.name.equals(query, ignoreCase = true) }) {
                        navController.navigate("PokemonView/${query.lowercase()}")
                        active = false
                    } else {
                        Toast.makeText(context, "This Pokemon doesn't exist", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
        
        Spacer(modifier = Modifier.padding(8.dp))
        
        SearchBar (
            query = query,
            onQueryChange = { query = it },
            onSearch = {
                isSearching = !isSearching
                if (filteredPokemon.any { it.name.equals(query, ignoreCase = true) }) {
                    navController.navigate("PokemonView/${query.lowercase()}")
                    active = false
                } else {
                    Toast.makeText(context, "This Pokemon doesn't exist", Toast.LENGTH_SHORT).show()
                }
            },
            active = active,
            onActiveChange = { active = it },
        ) {
            if (isSearching) {
                Box(
                    modifier = Modifier
                        .zIndex(1f)
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    filteredPokemon.forEach { name ->
                        Text(text = "$name")
                    }
                }
            }
        }
    }
}
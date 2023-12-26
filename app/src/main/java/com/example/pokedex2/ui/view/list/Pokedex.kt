package com.example.pokedex2.ui.view.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.ui.view.utils.MyTopAppBar
import com.example.pokedex2.viewModel.PokemonViewModel
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Pokedex(vm: PokemonViewModel, navController: NavHostController, drawerState: DrawerState) {
    LaunchedEffect(Unit) {
        vm.getPokemonList()
    }

    val dataList by vm.pokemonList.observeAsState(initial = PokedexResponse())
    val pokemonList = dataList.results

    if (pokemonList.isEmpty()) {
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Scaffold(
            topBar = { MyTopAppBar(drawerState, navController, pokemonList) },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 100.dp)
                ) {
                    itemsIndexed(pokemonList) { i, pokemon ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp)
                        ) {
                            Spacer(modifier = Modifier.padding(top = 8.dp))
                            Button(
                                onClick = {
                                    navController.navigate("PokemonView/${pokemon.name}")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(55.dp)
                            ) {
                                Text(
                                    text = "#${String.format("%04d", i + 1)} -  ${pokemon.name.replaceFirstChar {
                                        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                                    }}",
                                    textAlign = TextAlign.Start,
                                    fontSize = 24.sp,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}
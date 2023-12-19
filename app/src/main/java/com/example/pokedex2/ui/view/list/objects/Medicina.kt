package com.example.pokedex2.ui.view.list.objects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.viewModel.PokemonViewModel

@Composable
fun Medicina(vm: PokemonViewModel) {
    /*LaunchedEffect(Unit) {
        vm.getItemList()
    }

    val dataList by vm.itemList.observeAsState(initial = PokedexResponse())
    val abilityList = dataList.results

    if (abilityList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(abilityList) {
                Text(text = it.name)
            }
        }
    }*/
}
package com.example.pokedex2.ui.view.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.viewModel.PokemonViewModel

@Composable
fun TablaDeTipos(vm: PokemonViewModel) {
    LaunchedEffect(Unit) {
        vm.getTypeList()
    }

    val dataList by vm.typeList.observeAsState(initial = PokedexResponse())
    val typeList = dataList.results

    if (typeList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(typeList) { type ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                ) {
                    Button(
                        onClick = {
                            // Handle button click for the specific type item
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                    ) {
                        Text(
                            text = type.name.replaceFirstChar { it.uppercaseChar() },
                            textAlign = TextAlign.Center,
                            fontSize = 28.sp,
                        )
                    }
                }
            }
        }
    }
}
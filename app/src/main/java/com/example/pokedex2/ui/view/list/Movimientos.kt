package com.example.pokedex2.ui.view.list

import android.annotation.SuppressLint
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Movimientos(vm: PokemonViewModel, drawerState: DrawerState, navController: NavHostController) {
    LaunchedEffect(Unit) {
        vm.getMoveList()
    }

    val dataList by vm.moveList.observeAsState(initial = PokedexResponse())
    val moveList = dataList.results

    if (moveList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Scaffold(
            topBar = { MyTopAppBar(drawerState, navController, moveList) },
            content = {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(moveList) { move ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp)
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate("MoveView/${move.name}")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(55.dp)
                            ) {
                                Text(
                                    text = move.name.replaceFirstChar { it.uppercaseChar() },
                                    textAlign = TextAlign.Center,
                                    fontSize = 28.sp
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}
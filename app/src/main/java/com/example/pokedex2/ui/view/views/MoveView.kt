package com.example.pokedex2.ui.view.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Ability
import com.example.pokedex2.model.data.convert.Move
import com.example.pokedex2.viewModel.PokemonViewModel

@Composable
fun MoveView (
    vm: PokemonViewModel,
    selectedMove: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getMove(selectedMove!!)
    }

    val p by vm.selectedMove.observeAsState(initial = Move())

    Text(text = p.effect)
}
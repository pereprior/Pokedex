package com.example.pokedex2.ui.view.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Type
import com.example.pokedex2.viewModel.PokemonViewModel

@Composable
fun TypeView (
    vm: PokemonViewModel,
    selectedType: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getType(selectedType!!)
    }

    val p by vm.selectedType.observeAsState(initial = Type())

    Text(text = p.name, color = p.color)
}
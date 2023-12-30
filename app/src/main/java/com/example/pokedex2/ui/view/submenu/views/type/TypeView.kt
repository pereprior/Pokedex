package com.example.pokedex2.ui.view.submenu.views.type

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Type
import com.example.pokedex2.viewModel.PokedexViewModel

@Composable
fun TypeView (
    vm: PokedexViewModel,
    selectedType: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getType(selectedType!!)
    }

    val p by vm.selectedType.observeAsState(initial = Type())

    Text(text = p.name, color = p.color)
}
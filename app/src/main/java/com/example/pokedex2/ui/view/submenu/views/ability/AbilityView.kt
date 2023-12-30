package com.example.pokedex2.ui.view.submenu.views.ability

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Ability
import com.example.pokedex2.viewModel.PokedexViewModel

@Composable
fun AbilityView (
    vm: PokedexViewModel,
    selectedAbility: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getAbility(selectedAbility!!)
    }

    val p by vm.selectedAbility.observeAsState(initial = Ability())

    Text(text = p.effect)
}
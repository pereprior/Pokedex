package com.example.pokedex2.ui.views.view

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Ability
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.nav.BackFab
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AbilityView (
    vm: PokedexViewModel,
    selectedAbility: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getAbility(selectedAbility!!)
    }

    val a by vm.selectedAbility.observeAsState(initial = Ability())

    if (a.name.isEmpty()) {
        WaitCircle()
    } else {
        Scaffold (
            floatingActionButton = { BackFab(navController,"Abilities") },
            content = {
                Text(text = a.description)
            }
        )
    }
}
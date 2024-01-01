package com.example.pokedex2.ui.views.view

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Type
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.nav.BackFab
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TypeView (
    vm: PokedexViewModel,
    selectedType: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getType(selectedType!!)
    }

    val t by vm.selectedType.observeAsState(initial = Type())

    if (t.name.isEmpty()) {
        WaitCircle()
    } else {
        Scaffold (
            floatingActionButton = { BackFab(navController,"TypeTable") },
            content = {
                Text(text = t.name, color = t.color)
            }
        )
    }
}
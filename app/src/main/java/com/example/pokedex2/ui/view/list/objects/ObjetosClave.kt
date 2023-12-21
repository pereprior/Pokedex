package com.example.pokedex2.ui.view.list.objects

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.pokedex2.viewModel.PokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeyItem(vm: PokemonViewModel, drawerState: DrawerState) {
    Text(text = "Hola, soy Objetos Clave")
}
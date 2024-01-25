package com.example.pokedex2.ui.screens.detail.pokemon.head

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.constants.nav.POKEMON_NAVIGATION_LIST
import com.example.pokedex2.constants.nav.POKEMON_NAVIGATION_PACKAGE
import com.example.pokedex2.constants.nav.getAbsoluteNavigationPath
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.ui.components.icons.BackIcon

@Composable
fun PokemonDexNumberView(p: Pokemon, navController: NavHostController) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        BackIcon(
            navController = navController,
            route = getAbsoluteNavigationPath(POKEMON_NAVIGATION_PACKAGE, POKEMON_NAVIGATION_LIST)
        )

        DexNumber(p.dexNumber)
    }
}

@Composable
fun DexNumber(dexNumber: Int) {
    Text(
        text = "#${String.format("%04d", dexNumber)}",
        color = MaterialTheme.colorScheme.onPrimary,
        fontSize = 28.sp,
        textAlign = TextAlign.End
    )
}

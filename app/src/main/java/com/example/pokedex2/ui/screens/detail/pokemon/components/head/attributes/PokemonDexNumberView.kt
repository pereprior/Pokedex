package com.example.pokedex2.ui.screens.detail.pokemon.components.head.attributes

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
import com.example.pokedex2.constants.POKEMON_NAVIGATION_PATH
import com.example.pokedex2.constants.format.FOUR_DIGITS_FORMAT
import com.example.pokedex2.constants.values.HIGH_PADDING_VALUE
import com.example.pokedex2.ui.components.utils.icons.BackIcon

private const val DEX_NUMBER_FONT_SIZE = 28

@Composable
fun PokemonDexNumberView(
    pokemonDexNumber: Int,
    navController: NavHostController
) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(HIGH_PADDING_VALUE.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        // Boton para volver a la lista de pokemon
        BackIcon(
            navController = navController,
            route = POKEMON_NAVIGATION_PATH
        )

        // Numero de la pokedex del pokemon seleccionado
        Text(
            // Formato de texto para que siempre se vean 4 digitos en el numero de la pokedex
            text = "#${String.format(FOUR_DIGITS_FORMAT, pokemonDexNumber)}",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = DEX_NUMBER_FONT_SIZE.sp,
            textAlign = TextAlign.End
        )
    }
}
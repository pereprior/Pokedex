package com.example.pokedex2.ui.screens.detail.pokemon.components.head

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.domain.models.Pokemon
import com.example.pokedex2.ui.components.theme.PrimaryPokedexColor
import com.example.pokedex2.ui.screens.detail.pokemon.components.head.attributes.PokemonDexNumberView
import com.example.pokedex2.ui.screens.detail.pokemon.components.head.attributes.PokemonImageView

private const val SHAPE_VALUE = 54
private const val HEADER_HEIGHT = 220

@Composable
fun PokemonHeaderView(
    pokemonData: Pokemon,
    navController: NavHostController
) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(HEADER_HEIGHT.dp)
            .clip(
                shape = RoundedCornerShape(
                    bottomStart = SHAPE_VALUE.dp,
                    bottomEnd = SHAPE_VALUE.dp
                )
            )
            .background(color = PrimaryPokedexColor)
    ) {
        // Numero de pokedex y icono para volver a la lista de pokemon
        PokemonDexNumberView(
            pokemonDexNumber = pokemonData.dexNumber,
            navController = navController
        )

        // Imagen principal del pokemon
        PokemonImageView(pokemonData = pokemonData)
    }
}
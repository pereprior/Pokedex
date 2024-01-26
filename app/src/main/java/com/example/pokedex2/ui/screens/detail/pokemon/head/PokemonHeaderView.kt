package com.example.pokedex2.ui.screens.detail.pokemon.head

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
import com.example.pokedex2.ui.screens.detail.pokemon.head.image.PokemonImageView

@Composable
fun PokemonHeaderView(pokemonData: Pokemon, navController: NavHostController) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(bottomStart = 54.dp, bottomEnd = 54.dp))
            .background(color = PrimaryPokedexColor),
        contentAlignment = Alignment.Center
    ) {
        PokemonDexNumberView(pokemonData, navController)
        PokemonImageView(pokemonData)
    }
}
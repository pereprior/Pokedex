package com.example.pokedex2.ui.screens.detail.pokemon.head.image

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex2.model.data.convert.Pokemon

@Composable
fun PokemonImageView(pokemonData: Pokemon) {
    var isOpenDialog by rememberSaveable { mutableStateOf(false) }

    AsyncImage(
        model = pokemonData.normalSprite,
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .clickable {
                isOpenDialog = true
            }
    )

    if (isOpenDialog) {
        PokemonSpritesDialog(
            onDismissRequest = { isOpenDialog = false },
            spritesList = pokemonData.forms
        )
    }
}
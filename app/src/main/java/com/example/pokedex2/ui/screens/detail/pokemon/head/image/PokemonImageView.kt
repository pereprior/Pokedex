package com.example.pokedex2.ui.screens.detail.pokemon.head.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex2.R
import com.example.pokedex2.constants.error.ERROR_651_DESCRIPTION
import com.example.pokedex2.constants.error.ERROR_651_TITLE
import com.example.pokedex2.domain.models.Pokemon
import com.example.pokedex2.ui.components.error.dialog.NotFoundDialog

@Composable
fun PokemonImageView(pokemonData: Pokemon) {
    var isOpenDialog by rememberSaveable { mutableStateOf(false) }
    var isError by rememberSaveable { mutableStateOf(false) }

    AsyncImage(
        model = pokemonData.artwork,
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .clickable {
                isOpenDialog = true
            },
        onError = {
            isError = true
        }
    )

    if (isError) {
        Image(
            painter = painterResource(id = R.drawable.ditto),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
    }

    if (isOpenDialog) {
        if (isError) {
            NotFoundDialog(
                onDismissRequest = { isOpenDialog = false },
                title = ERROR_651_TITLE,
                description = ERROR_651_DESCRIPTION
            )
        } else {
            PokemonSpritesDialog(
                onDismissRequest = { isOpenDialog = false },
                spritesList = pokemonData.sprites
            )
        }
    }
}
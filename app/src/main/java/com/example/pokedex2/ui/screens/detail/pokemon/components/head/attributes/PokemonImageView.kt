package com.example.pokedex2.ui.screens.detail.pokemon.components.head.attributes

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
import com.example.pokedex2.constants.messages.ERROR_651_DESCRIPTION
import com.example.pokedex2.constants.messages.ERROR_651_TITLE
import com.example.pokedex2.domain.models.Pokemon
import com.example.pokedex2.ui.components.utils.dialog.NotFoundDialog
import com.example.pokedex2.ui.components.utils.dialog.PokemonSpritesDialog

private const val IMAGE_SIZE = 200

@Composable
fun PokemonImageView(pokemonData: Pokemon) {
    var isOpenDialog by rememberSaveable { mutableStateOf(false) }
    var isError by rememberSaveable { mutableStateOf(false) }

    // Carga la imagen de internet del pokemon seleccionado
    AsyncImage(
        model = pokemonData.artwork,
        contentDescription = "Pokemon Image",
        modifier = Modifier
            .size(IMAGE_SIZE.dp)
            .clickable {
                isOpenDialog = true
            },
        onError = {
            isError = true
        }
    )

    // Si ocurre algun error, saldra la imagen de ditto
    if (isError) {
        Image(
            painter = painterResource(id = R.drawable.ditto),
            contentDescription = null,
            modifier = Modifier.size(IMAGE_SIZE.dp)
        )
    }

    if (isOpenDialog) {
        // Sale mensaje adviertiendo que hay un fallo de conexion
        if (isError) {
            NotFoundDialog(
                onDismissRequest = { isOpenDialog = false },
                title = ERROR_651_TITLE,
                description = ERROR_651_DESCRIPTION
            )
        // Salen los diferentes sprites del pokemon
        } else {
            PokemonSpritesDialog(
                onDismissRequest = { isOpenDialog = false },
                spritesList = pokemonData.sprites
            )
        }
    }
}
package com.example.pokedex2.ui.components.utils.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.example.pokedex2.ui.components.utils.icons.CloseIcon

@Composable
fun PokemonSpritesDialog(
    onDismissRequest: () -> Unit,
    spritesList: List<Any>, // La lista es ANY ya que puede recibir nulos. No todos los pokemon tienen sprites diferentes para las hembras
) {
    // Muestra los diferentes sprites del pokemon cuando pulsas sibre su imagen
    Dialog (
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Box (
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                PokemonSpritesList(spritesList)
                CloseIcon(onDismissRequest)
            }
        }
    }
}

@Composable
private fun PokemonSpritesList(images: List<Any>) {
    LazyColumn {
        items(images) {imageUrl ->
            if (imageUrl is String) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Pokemon Sprite",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(160.dp)
                )
            }
        }
    }
}
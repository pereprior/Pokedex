package com.example.pokedex2.ui.components.utils.loading

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LoadingImage(
    imageResId: Int,
    // Tendra un valor por defecto de 50, pero se puede modificar al llamar a la funcion si se quiere
    imageSize: Int = 50
) {
    // Animacion para la imagen para que cree una sensacion de carga.
    val infiniteTransition = rememberInfiniteTransition(label = "ImageTransition")
    val scale by infiniteTransition.animateFloat(
        label = "ImageScaleAnimation",
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800),
            repeatMode = RepeatMode.Reverse
        )
    )

    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "Loading Image",
        modifier = Modifier
            .size(imageSize.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale),
        contentScale = ContentScale.Crop
    )
}
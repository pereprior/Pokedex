package com.example.pokedex2.ui.menu

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun HelpBell() {
    var isBellAnimated by rememberSaveable { mutableStateOf(true) }
    val helpValue by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = if (isBellAnimated) 25f else 0f,
        targetValue = if (isBellAnimated) -25f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    Box (
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(onClick = {
            isBellAnimated = false
            /* TODO */
        }) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Help Bell",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .graphicsLayer {
                        transformOrigin = TransformOrigin(
                            pivotFractionX = 0.5f,
                            pivotFractionY = 0.0f
                        )
                        rotationZ = helpValue
                    }
            )
        }
    }
}
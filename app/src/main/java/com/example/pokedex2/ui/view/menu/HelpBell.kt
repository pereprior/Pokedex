package com.example.pokedex2.ui.view.menu

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun HelpBell() {
    val helpValue by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 25f,
        targetValue = -25f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    BellIcon(helpValue)
}

@Composable
private fun BellIcon(helpValue: Float) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Help Bell",
            tint = MaterialTheme.colorScheme.onPrimary,
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
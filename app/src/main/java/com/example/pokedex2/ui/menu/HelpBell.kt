package com.example.pokedex2.ui.menu

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun HelpBell() {
    var isOpenDialog by rememberSaveable { mutableStateOf(false) }
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
            isOpenDialog = true
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

    if (isOpenDialog){
        HelpDialog( onDismissRequest = { isOpenDialog = false } )
    }
}

@Composable
private fun HelpDialog(
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = { onDismissRequest() },
        content = {
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box (
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopEnd
                ) {
                    IconButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
                Icon(imageVector = Icons.Filled.Info, contentDescription = "", tint = Color.White)
                Text(text = "Pokedex Info", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Gracias por utilizar nuestra aplicación.\nUna vez que accedas a una de las opciones del menu no será necesario volver a este, puedes pulsar las tres rayas horizontales y desplazarte usando la ventana emergente.\nEl programa está totalmente en inglés",
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .drawBehind {
                            drawRoundRect(
                                Color.Black.copy(alpha = 0.6f)
                            )
                        }
                        .padding(20.dp)
                )
            }
        }
    )
}
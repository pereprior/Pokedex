package com.example.pokedex2.ui.components.theme.text.color

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RedAlertText(text: String) {
    Text(text = text, modifier = Modifier.padding(8.dp), color = Color.Red)
}
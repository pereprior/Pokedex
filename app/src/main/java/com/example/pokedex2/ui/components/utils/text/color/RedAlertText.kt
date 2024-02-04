package com.example.pokedex2.ui.components.utils.text.color

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex2.constants.values.MEDIUM_PADDING_VALUE

@Composable
fun RedAlertText(text: String) {
    Text(text = text, modifier = Modifier.padding(MEDIUM_PADDING_VALUE.dp), color = Color.Red)
}
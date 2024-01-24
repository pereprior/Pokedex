package com.example.pokedex2.ui.components.theme.text.color

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex2.ui.components.theme.LightGrey

@Composable
fun LightGreyText(text: String) {
    Text(text = text, modifier = Modifier.padding(8.dp), color = LightGrey)
}
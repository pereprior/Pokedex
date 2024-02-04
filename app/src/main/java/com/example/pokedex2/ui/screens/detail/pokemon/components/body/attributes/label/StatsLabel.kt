package com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.label

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex2.constants.values.MEDIUM_PADDING_VALUE

@Composable
fun StatNameLabel(name: String) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .height(16.dp)
            .width(80.dp)
    ) {
        Text(
            text = name.uppercase(),
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
fun StatNumberLabel(
    statPosition: Float,
    statValue: Int
) {
    Box(
        modifier = Modifier
            .width(statPosition.dp)
            .padding(bottom = MEDIUM_PADDING_VALUE.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Text(text = "$statValue")
    }
}
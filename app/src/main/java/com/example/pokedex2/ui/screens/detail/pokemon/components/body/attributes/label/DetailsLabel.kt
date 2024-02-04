package com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.label

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex2.constants.values.HIGH_PADDING_VALUE
import com.example.pokedex2.constants.values.MEDIUM_PADDING_VALUE
import com.example.pokedex2.ui.components.utils.text.format.capitalized

private const val LABEL_WIDTH = 150
private const val LABEL_HEIGHT = 30

@Composable
fun DetailsLabel(
    color: Color,
    message: String
) {
    Box(
        modifier = Modifier
            .width(LABEL_WIDTH.dp)
            .height(LABEL_HEIGHT.dp)
            .padding(horizontal = MEDIUM_PADDING_VALUE.dp)
            .clip(RoundedCornerShape(HIGH_PADDING_VALUE.dp))
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = capitalized(message))
    }
}
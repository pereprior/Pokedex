package com.example.pokedex2.ui.components.utils.canvan

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex2.constants.values.HIGH_PADDING_VALUE
import com.example.pokedex2.constants.values.MEDIUM_PADDING_VALUE

@Composable
fun CanvasBarTemplate(
    barWidth: Int,
    barHeight: Int,
    barColor: Color
) {
    Canvas(
        modifier = Modifier
            .width(barWidth.dp)
            .height(barHeight.dp)
            .padding(MEDIUM_PADDING_VALUE.dp)
            .clip(RoundedCornerShape(HIGH_PADDING_VALUE.dp))
    ) {
        drawRect(
            color = barColor,
            topLeft = Offset(0f, 0f),
        )
    }
}
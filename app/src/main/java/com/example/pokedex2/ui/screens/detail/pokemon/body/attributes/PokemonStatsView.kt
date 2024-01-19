package com.example.pokedex2.ui.screens.detail.pokemon.body.attributes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex2.model.api.response.pokemon.Stat
import com.example.pokedex2.ui.components.LightGreyText
import com.example.pokedex2.ui.components.theme.AtkColor
import com.example.pokedex2.ui.components.theme.DefColor
import com.example.pokedex2.ui.components.theme.HPColor
import com.example.pokedex2.ui.components.theme.SpAtkColor
import com.example.pokedex2.ui.components.theme.SpDefColor
import com.example.pokedex2.ui.components.theme.SpdColor

// Constantes
private const val MAX_STAT_VALUE = 165
private const val MIN_STAT_VALUE = 20
private const val STAT_BAR_WIDTH = 300
private const val STAT_BAR_HEIGHT = 36
private const val STAT_BAR_PADDING = 8
private const val STAT_BAR_CORNER_RADIUS = 16
private const val STAT_BAR_SCALE_FACTOR = 2
private const val STAT_TEXT_SCALE_FACTOR = 1.5
private const val STAT_TEXT_BOTTOM_PADDING = 10
private const val STAT_TEXT_FONT_SIZE = 14

@Composable
fun PokemonStatsView(stats: List<Stat>) {
    LightGreyText(text = "Base Stats")
    stats.forEach { stat ->
        StatSection(stat)
    }
}

@Composable
private fun StatSection(stat: Stat) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatName(stat.stat.name)

        val barSize = when {
            stat.base_stat > MAX_STAT_VALUE -> MAX_STAT_VALUE
            stat.base_stat < MIN_STAT_VALUE -> MIN_STAT_VALUE
            else -> stat.base_stat
        }

        StatBar(stat = stat, barSize = barSize)
    }
}

@Composable
private fun StatName(name: String) {
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

// TODO REFECTOR STATBAR
@Composable
private fun StatBar(stat: Stat, barSize: Int) {
    val backgroundBarColor = MaterialTheme.colorScheme.onPrimary

    Box {
        BarTemplate(
            barWidth = STAT_BAR_WIDTH,
            barColor = backgroundBarColor
        )

        Box(contentAlignment = Alignment.BottomCenter) {
            BarTemplate(
                barWidth = (barSize * STAT_BAR_SCALE_FACTOR),
                barColor = getStatColor(stat.stat.name)
            )
            Box(
                modifier = Modifier
                    .width((barSize * STAT_TEXT_SCALE_FACTOR).dp)
                    .padding(bottom = STAT_TEXT_BOTTOM_PADDING.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text(
                    text = "${stat.base_stat}",
                    fontSize = STAT_TEXT_FONT_SIZE.sp
                )
            }
        }
    }

}

@Composable
private fun BarTemplate(barWidth: Int, barColor: Color) {
    Canvas(
        modifier = Modifier
            .width(barWidth.dp)
            .height(STAT_BAR_HEIGHT.dp)
            .padding(STAT_BAR_PADDING.dp)
            .clip(RoundedCornerShape(STAT_BAR_CORNER_RADIUS.dp))
    ) {
        drawRect(
            color = barColor,
            topLeft = Offset(0f, 0f),
        )
    }
}

private fun getStatColor(statName: String): Color {
    return when (statName) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.Gray
    }
}
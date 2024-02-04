package com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex2.constants.values.HIGH_PADDING_VALUE
import com.example.pokedex2.ui.components.utils.text.color.LightGreyText
import com.example.pokedex2.ui.components.theme.getStatColor
import com.example.pokedex2.ui.components.utils.canvas.CanvasBarTemplate
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.label.StatNameLabel
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.label.StatNumberLabel

private const val MAX_STAT_VALUE = 165
private const val MIN_STAT_VALUE = 20
private const val STAT_BAR_WIDTH = 300
private const val STAT_BAR_HEIGHT = 36
private const val STAT_BAR_SCALE_FACTOR = 2
private const val STAT_TEXT_SCALE_FACTOR = 1.5f

@Composable
fun PokemonStatsView(pokemonStats: Map<String, Int>) {
    LightGreyText(text = "Base Stats")

    pokemonStats.forEach { stat ->
        StatSection(
            statType = stat.key,
            statValue = stat.value
        )
    }
}

@Composable
private fun StatSection(
    statType: String,
    statValue: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = HIGH_PADDING_VALUE.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatNameLabel(name = statType)

        // Filtrar la longitud de la barra, ya que como hay pokemon que tienen stats muy altas/bajas, la barra se ve horrible si no ponemos un limite
        val barSize = statValue.coerceIn(
            minimumValue = MIN_STAT_VALUE,
            maximumValue = MAX_STAT_VALUE
        )

        StatBar(
            statValue = statValue,
            barSize = barSize,
            // He asignado un color para cada tipo de estadistica
            barColor = getStatColor(statType)
        )
    }
}

@Composable
private fun StatBar(
    statValue: Int,
    barSize: Int,
    barColor: Color
) {
    Box {
        // Barra de fondo
        CanvasBarTemplate(
            barWidth = STAT_BAR_WIDTH,
            barHeight = STAT_BAR_HEIGHT,
            barColor = MaterialTheme.colorScheme.onPrimary
        )

        // Barra principal con la informacion de la stat del pokemon
        MainBarContent(barSize, barColor, statValue)
    }
}

@Composable
private fun MainBarContent(
    barSize: Int,
    barColor: Color,
    statValue: Int
) {
    val barFinalWidth = barSize * STAT_BAR_SCALE_FACTOR
    val statValuePosition = barSize * STAT_TEXT_SCALE_FACTOR

    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        // Barra de color con la longitud de la stat del pokemon
        CanvasBarTemplate(
            barWidth = barFinalWidth,
            barHeight = STAT_BAR_HEIGHT,
            barColor = barColor
        )

        // Numero con el valor especifico de la stat
        StatNumberLabel(
            statPosition = statValuePosition,
            statValue = statValue
        )
    }
}
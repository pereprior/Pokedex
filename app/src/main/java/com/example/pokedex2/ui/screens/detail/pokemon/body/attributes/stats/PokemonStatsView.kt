package com.example.pokedex2.ui.screens.detail.pokemon.body.attributes.stats

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.pokedex2.ui.components.theme.AtkColor
import com.example.pokedex2.ui.components.theme.DefColor
import com.example.pokedex2.ui.components.theme.HPColor
import com.example.pokedex2.ui.components.theme.LightGrey
import com.example.pokedex2.ui.components.theme.SpAtkColor
import com.example.pokedex2.ui.components.theme.SpDefColor
import com.example.pokedex2.ui.components.theme.SpdColor

@Composable
fun PokemonStats(stats: List<Stat>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Base Stats", modifier = Modifier.padding(bottom = 8.dp, top = 16.dp), color = LightGrey)
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp)) {
            stats.map { stat ->
                MyStat(stat)
            }
        }
    }
}

@Composable
private fun MyStat(stat: Stat) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .height(16.dp)
                .width(80.dp)
        ) {
            Text(text = stat.stat.name.uppercase(), color = MaterialTheme.colorScheme.onSecondary)
        }
        Spacer(modifier = Modifier.padding(8.dp))

        val barSize = when {
            stat.base_stat > 165 -> 165
            stat.base_stat < 20 -> 20
            else -> stat.base_stat
        }

        Box {
            Canvas(modifier = Modifier
                .width(300.dp)
                .height(36.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp))
            ) {
                drawRect(
                    color = Color.White,
                    topLeft = Offset(0f, 0f),
                )
            }

            Box(contentAlignment = Alignment.BottomCenter) {
                Canvas(
                    modifier = Modifier
                        .width((barSize * 2).dp)
                        .height(36.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    drawRect(
                        color = getStatColor(stat.stat.name),
                        topLeft = Offset(0f, 0f),
                    )
                }

                Box(
                    modifier = Modifier
                        .width((barSize * 1.5).dp)
                        .padding(bottom = 10.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "${stat.base_stat}",
                        fontSize = 14.sp
                    )
                }
            }
        }
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
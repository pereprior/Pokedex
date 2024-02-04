package com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex2.constants.MEASURE_UNIT_KEY
import com.example.pokedex2.constants.WEIGHT_UNIT_KEY

@Composable
fun PokemonSizeView(
    pokemonWeight: Float,
    pokemonHeight: Float
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SizeViewTemplate(
            value = pokemonWeight,
            // Seleccionar la diferente unidad de peso (kg, lib,...)
            unitKey = WEIGHT_UNIT_KEY
        )

        SizeViewTemplate(
            value = pokemonHeight,
            // Seleccionar la diferente unidad de medida (m, ft,...)
            unitKey = MEASURE_UNIT_KEY
        )
    }
}

@Composable
private fun SizeViewTemplate(value: Float, unitKey: String) {
    Text(
        text = "$value $unitKey",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSecondary
    )
}
package com.example.pokedex2.ui.screens.detail.pokemon.body.attributes

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
import com.example.pokedex2.constants.language.MEASURE_UNIT_KEY
import com.example.pokedex2.constants.language.WEIGHT_UNIT_KEY
import com.example.pokedex2.domain.models.Pokemon

@Composable
fun PokemonSizeView(p: Pokemon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SizeViewTemplate(
            value = p.weight,
            unitKey = WEIGHT_UNIT_KEY
        )

        SizeViewTemplate(
            value = p.height,
            unitKey = MEASURE_UNIT_KEY
        )
    }
}

@Composable
private fun SizeViewTemplate(value: Float, unitKey: String) {
    Text(
        text = "$value $unitKey}",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSecondary
    )
}
package com.example.pokedex2.ui.screens.detail.pokemon.body.attributes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.model.data.convert.SizeType
import com.example.pokedex2.ui.components.theme.text.color.LightGreyText

@Composable
fun PokemonSize(p: Pokemon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MySize(value = p.weight, sizeType = SizeType.KG)
        MySize(value = p.height, sizeType = SizeType.M)
    }
}

@Composable
private fun MySize(value: Float, sizeType: SizeType) {
    Column {
        Text(
            text = "$value ${sizeType.unit}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        LightGreyText(text = sizeType.label)
    }
}
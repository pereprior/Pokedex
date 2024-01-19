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
import com.example.pokedex2.ui.components.theme.LightGrey

@Composable
fun PokemonSize(p: Pokemon){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        MySize(p.weight, SizeType.KG)
        MySize(p.height, SizeType.M)
    }
}

@Composable
private fun MySize(value: Float, size: SizeType) {
    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$value ${size.name}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = size.value,
            color = LightGrey
        )
    }
}

private enum class SizeType(val value: String) {
    KG("Weight"),
    M("Height")
}
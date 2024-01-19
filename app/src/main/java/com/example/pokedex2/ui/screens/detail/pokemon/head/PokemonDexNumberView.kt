package com.example.pokedex2.ui.screens.detail.pokemon.head

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex2.model.data.convert.Pokemon

@Composable
fun PokemonDexNumberView(p: Pokemon) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Text(
            text = "#${String.format("%04d", p.dexNumber)}",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 28.sp,
        )
    }
}
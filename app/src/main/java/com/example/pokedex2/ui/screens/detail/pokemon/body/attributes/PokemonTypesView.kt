package com.example.pokedex2.ui.screens.detail.pokemon.body.attributes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex2.model.api.response.pokemon.Type
import com.example.pokedex2.ui.components.MyLabel
import com.example.pokedex2.ui.components.getTypeColor

@Composable
fun PokemonTypesView(types: List<Type>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        types.map { type ->
            PokemonTypeLabel(type)
        }
    }
}

@Composable
private fun PokemonTypeLabel(type: Type) {
    val color = getTypeColor(type.type)

    MyLabel(color, type.type.name)
}
package com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex2.ui.components.theme.getTypeColor
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.label.DetailsLabel

@Composable
fun PokemonTypesView(pokemonTypes: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Como los pokemon pueden tener mas de un tipo, hacemos un label por cada tipo
        pokemonTypes.map { type ->
            PokemonTypeLabel(type)
        }
    }
}

@Composable
private fun PokemonTypeLabel(typeName: String) {
    val color = getTypeColor(typeName)

    DetailsLabel(color, typeName)
}
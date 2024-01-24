package com.example.pokedex2.ui.screens.detail.pokemon.body

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.ui.components.theme.text.format.capitalized
import com.example.pokedex2.ui.screens.detail.pokemon.body.attributes.PokemonAbilityView
import com.example.pokedex2.ui.screens.detail.pokemon.body.attributes.PokemonSize
import com.example.pokedex2.ui.screens.detail.pokemon.body.attributes.PokemonTypesView
import com.example.pokedex2.ui.screens.detail.pokemon.body.attributes.PokemonStatsView

@Composable
fun PokemonBodyView(pokemonData: Pokemon){
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PokemonNameView(pokemonData)
        PokemonTypesView(types = pokemonData.types)
        PokemonAbilityView(abilities = pokemonData.abilities)
        PokemonStatsView(stats = pokemonData.stats)
        Spacer(modifier = Modifier.padding(16.dp))
        PokemonSize(p = pokemonData)
    }
}

@Composable
private fun PokemonNameView(pokemonData: Pokemon) {
    Text(
        text = capitalized(pokemonData.name),
        fontSize = 40.sp,
        color = MaterialTheme.colorScheme.onSecondary,
    )
}
package com.example.pokedex2.ui.screens.detail.pokemon.components.body

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
import com.example.pokedex2.domain.models.Pokemon
import com.example.pokedex2.ui.components.utils.text.format.capitalized
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.PokemonAbilityView
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.PokemonSizeView
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.PokemonTypesView
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.PokemonStatsView

@Composable
fun PokemonBodyView(pokemonData: Pokemon){
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Nombre del Pokemon
        Text(
            text = capitalized(pokemonData.name),
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.onSecondary,
        )

        // Label con los tipos del pokemon
        PokemonTypesView(pokemonTypes = pokemonData.types)

        // Label con las abilidades del pokemon
        PokemonAbilityView(pokemonAbilities = pokemonData.abilities)

        // Barras con las estadisticas del pokemon
        PokemonStatsView(pokemonStats = pokemonData.stats)

        Spacer(modifier = Modifier.padding(16.dp))
        // Peso y Altura del pokemon
        PokemonSizeView(
            pokemonWeight = pokemonData.weight,
            pokemonHeight = pokemonData.height
        )
    }
}
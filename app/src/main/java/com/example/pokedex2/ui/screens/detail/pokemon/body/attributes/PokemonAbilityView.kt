package com.example.pokedex2.ui.screens.detail.pokemon.body.attributes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex2.model.api.response.pokemon.Ability
import com.example.pokedex2.ui.components.MyLabel
import com.example.pokedex2.ui.components.theme.LightGrey

@Composable
fun PokemonAbilities(abilities: List<Ability>) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val normalAbilities = abilities.filter { !it.is_hidden }
        val hiddenAbilities = abilities.filter { it.is_hidden }

        Text(text = "Normal Abilities", modifier = Modifier.padding(8.dp), color = LightGrey)
        Row {
            PokemonAbilityLabel(normalAbilities)
        }

        if (hiddenAbilities.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Hidden Abilities", modifier = Modifier.padding(8.dp), color = LightGrey)
            PokemonAbilityLabel(hiddenAbilities)
        }
    }
}

@Composable
private fun PokemonAbilityLabel(abilities: List<Ability>) {
    abilities.forEach { ability ->
        MyLabel(
            color = MaterialTheme.colorScheme.primary,
            message = ability.ability.name
        )
    }
}
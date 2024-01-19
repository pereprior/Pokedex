package com.example.pokedex2.ui.screens.detail.pokemon.body.attributes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
fun PokemonAbilityView(abilities: List<Ability>) {
    val normalAbilities = abilities.filter { !it.is_hidden }
    val hiddenAbilities = abilities.filter { it.is_hidden }

    AbilitiesSection("Normal Abilities", normalAbilities)

    // Hay algunos pokemon que no tienen habilidades ocultas
    if (hiddenAbilities.isNotEmpty()) {
        AbilitiesSection("Hidden Abilities", hiddenAbilities)
    }
}

@Composable
private fun AbilitiesSection(title: String, abilities: List<Ability>) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, modifier = Modifier.padding(8.dp), color = LightGrey)
        Row {
            abilities.forEach { ability ->
                AbilityLabel(ability.ability.name)
            }
        }
    }
}

@Composable
private fun AbilityLabel(abilityName: String) {
    MyLabel(
        color = MaterialTheme.colorScheme.primary,
        message = abilityName
    )
}
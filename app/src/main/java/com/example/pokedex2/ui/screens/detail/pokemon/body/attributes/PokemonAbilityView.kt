package com.example.pokedex2.ui.screens.detail.pokemon.body.attributes

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.pokedex2.model.api.response.pokemon.Ability
import com.example.pokedex2.ui.components.theme.text.color.LightGreyText
import com.example.pokedex2.ui.screens.detail.pokemon.body.attributes.common.PokemonDetailsLabel

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
    LightGreyText(title)

    Row {
        abilities.forEach { ability ->
            AbilityLabel(ability.ability.name)
        }
    }
}

@Composable
private fun AbilityLabel(abilityName: String) {
    PokemonDetailsLabel(
        color = MaterialTheme.colorScheme.primary,
        message = abilityName
    )
}
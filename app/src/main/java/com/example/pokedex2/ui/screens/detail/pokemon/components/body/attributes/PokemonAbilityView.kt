package com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.pokedex2.ui.components.utils.text.color.LightGreyText
import com.example.pokedex2.ui.screens.detail.pokemon.components.body.attributes.label.DetailsLabel

@Composable
fun PokemonAbilityView(pokemonAbilities: Map<String,Boolean>) {
    // Filtramos las abilidades entre normales y ocultas
    val normalAbilities = pokemonAbilities.filter { !it.value }
    val hiddenAbilities = pokemonAbilities.filter { it.value }

    AbilitiesSection(
        title = "Normal Abilities",
        abilities = normalAbilities
    )

    // No todos los pokemon tienen habilidades ocultas
    if (hiddenAbilities.isNotEmpty()) {
        AbilitiesSection(
            title = "Hidden Abilities",
            abilities = hiddenAbilities
        )
    }
}

@Composable
private fun AbilitiesSection(title: String, abilities: Map<String,Boolean>) {
    LightGreyText(title)

    // Puede haber más de una habilidad del mismo tipo
    Row {
        abilities.forEach { ability ->
            DetailsLabel(
                color = MaterialTheme.colorScheme.primary,
                message = ability.key
            )
        }
    }
}
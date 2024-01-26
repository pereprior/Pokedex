package com.example.pokedex2.data.mappers

import com.example.pokedex2.data.sources.remote.dto.detail.PokemonDetailDTO
import com.example.pokedex2.domain.models.Pokemon

class PokemonDetailDataMapper(
    private val pokemonDetails: PokemonDetailDTO
) : IDataMapper {
    override fun convert(): Pokemon {
        return Pokemon(
            dexNumber = pokemonDetails.id,
            name = pokemonDetails.name,
            height = pokemonDetails.height.toFloat(),
            weight = pokemonDetails.weight.toFloat(),
            stats = pokemonStatsConvert(),
            abilities = pokemonDetails.abilities.map { it.ability.name },
            types = pokemonDetails.types.map { it.type.name },
            artwork = pokemonDetails.sprites.other.official.front_default,
            sprites = listOf(
                pokemonDetails.sprites.front_default,
                pokemonDetails.sprites.back_default,
                pokemonDetails.sprites.front_female,
                pokemonDetails.sprites.back_female,
                pokemonDetails.sprites.front_shiny,
                pokemonDetails.sprites.back_shiny,
                pokemonDetails.sprites.front_shiny_female,
                pokemonDetails.sprites.back_shiny_female
            )
        )
    }

    private fun pokemonStatsConvert(): Map<String,Int>{
        val pokemonStatsConverted = HashMap<String,Int>()

        pokemonDetails.stats.map {
            pokemonStatsConverted.put(
                key = it.stat.name,
                value = it.base_stat
            )
        }

        return pokemonStatsConverted
    }
}
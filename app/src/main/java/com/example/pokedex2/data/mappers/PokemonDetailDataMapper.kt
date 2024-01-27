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
            artwork = pokemonDetails.sprites.other.official.frontDefault,
            sprites = listOf(
                pokemonDetails.sprites.frontDefault,
                pokemonDetails.sprites.backDefault,
                pokemonDetails.sprites.frontFemale,
                pokemonDetails.sprites.backFemale,
                pokemonDetails.sprites.frontShiny,
                pokemonDetails.sprites.backShiny,
                pokemonDetails.sprites.frontShinyFemale,
                pokemonDetails.sprites.backShinyFemale
            )
        )
    }

    private fun pokemonStatsConvert(): Map<String,Int>{
        val pokemonStatsConverted = HashMap<String,Int>()

        pokemonDetails.stats.map {
            pokemonStatsConverted.put(
                key = it.stat.name,
                value = it.baseStat
            )
        }

        return pokemonStatsConverted
    }
}
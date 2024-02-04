package com.example.pokedex2.data.mappers.pokemon

import com.example.pokedex2.constants.REFACTOR_UNIT
import com.example.pokedex2.data.mappers.IDataMapper
import com.example.pokedex2.data.sources.dto.pokemon.detail.PokemonDetailDTO
import com.example.pokedex2.domain.models.Pokemon

class PokemonDetailDataMapper(
    private val pokemonDetails: PokemonDetailDTO
) : IDataMapper {
    // Convertimos un DetailDTO en un objeto Pokemon
    override fun convert(): Pokemon {
        return Pokemon(
            dexNumber = pokemonDetails.id,
            name = pokemonDetails.name,
            height = pokemonDetails.height * REFACTOR_UNIT, // Convertimos a la unidad de medida seleccionada
            weight = pokemonDetails.weight * REFACTOR_UNIT,
            stats = pokemonStatsConvert(),
            abilities = pokemonAbilitiesConvert(),
            types = pokemonDetails.types.map { it.type.name },
            artwork = pokemonDetails.sprites.other.home.frontDefault,
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

        // Extraemos el nombre de la estadistica y su valor
        pokemonDetails.stats.map {
            pokemonStatsConverted.put(
                key = it.stat.name,
                value = it.baseStat
            )
        }

        return pokemonStatsConverted
    }

    private fun pokemonAbilitiesConvert(): Map<String, Boolean> {
        val pokemonAbilitiesConverted = HashMap<String,Boolean>()

        // Extraemos el nombre de la habilidad y un valor que indique si es oculta o no
        pokemonDetails.abilities.map {
            pokemonAbilitiesConverted.put(
                key = it.ability.name,
                value = it.isHidden
            )
        }

        return pokemonAbilitiesConverted
    }

}
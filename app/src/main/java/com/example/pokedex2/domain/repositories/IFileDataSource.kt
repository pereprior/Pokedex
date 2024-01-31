package com.example.pokedex2.domain.repositories

import com.example.pokedex2.data.sources.dto.detail.PokemonDetailDTO
import com.example.pokedex2.data.sources.dto.list.PokemonListDTO

interface IFileDataSource {
    fun obtainDetailsFromJson(dataName: String): PokemonDetailDTO
    fun obtainListFromJson(data: String): PokemonListDTO
}
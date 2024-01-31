package com.example.pokedex2.domain.repositories

import com.example.pokedex2.domain.models.Pokemon

interface PokemonRepository {
    suspend fun getListData(dataName: String): List<String>
    suspend fun getDetailData(dataName: String): Pokemon
}
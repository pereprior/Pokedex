package com.example.pokedex2.domain.usecases

import com.example.pokedex2.data.repositories.PokemonRepositoryImpl
import com.example.pokedex2.domain.models.Pokemon
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(private val repository: PokemonRepositoryImpl) {
    suspend fun execute(name: String): Pokemon {
        return repository.getDetailData(name)
    }
}
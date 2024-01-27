package com.example.pokedex2.domain.usecases

import com.example.pokedex2.data.repositories.PokemonRepositoryImpl
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val repository: PokemonRepositoryImpl) {
    suspend fun execute(): List<String> {
        return repository.getListData("pokemon")
    }
}

package com.example.pokedex2.domain.usecases

import com.example.pokedex2.data.repositories.PokemonRepositoryImpl
import com.example.pokedex2.data.sources.remote.dto.list.PokemonListDTO

class GetPokemonListUseCase(private val repository: PokemonRepositoryImpl) {
    suspend fun execute(): Result<PokemonListDTO> {
        return repository.getListData("pokemon")
    }
}

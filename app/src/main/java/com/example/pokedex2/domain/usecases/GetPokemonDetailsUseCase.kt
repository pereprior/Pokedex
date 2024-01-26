package com.example.pokedex2.domain.usecases

import com.example.pokedex2.data.repositories.PokemonRepositoryImpl
import com.example.pokedex2.data.sources.remote.dto.detail.PokemonDetailDTO

class GetPokemonDetailsUseCase(private val repository: PokemonRepositoryImpl) {
    suspend fun execute(name: String): Result<PokemonDetailDTO> {
        return repository.getDetailData(name)
    }
}
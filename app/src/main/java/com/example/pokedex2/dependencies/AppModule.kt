package com.example.pokedex2.dependencies

import com.example.pokedex2.data.sources.remote.PokemonApiService
import com.example.pokedex2.data.repositories.PokemonRepositoryImpl
import com.example.pokedex2.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex2.domain.usecases.GetPokemonDetailsUseCase
import com.example.pokedex2.domain.usecases.GetPokemonListUseCase
import com.example.pokedex2.ui.viewmodels.PokedexViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): PokemonApiService {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(PokemonApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: PokemonApiService): PokemonRepositoryImpl {
        return PokemonRepositoryImpl(
            PokemonRemoteDataSource(api)
        )
    }

    @Provides
    @Singleton
    fun provideViewModel(repository: PokemonRepositoryImpl): PokedexViewModel {
        return PokedexViewModel(
            GetPokemonListUseCase(repository),
            GetPokemonDetailsUseCase(repository)
        )
    }
}
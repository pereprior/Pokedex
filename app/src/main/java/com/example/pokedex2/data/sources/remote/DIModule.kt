package com.example.pokedex2.data.sources.remote

import android.app.Application
import com.example.pokedex2.data.repositories.PokemonRepositoryImpl
import com.example.pokedex2.data.sources.local.file.PokemonFileDataSource
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
object DIModule {
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
    fun provideRepository(
        api: PokemonApiService,
        application: Application
    ): PokemonRepositoryImpl {
        return PokemonRepositoryImpl(
            PokemonRemoteDataSource(api),
            PokemonFileDataSource(application)
        )
    }
}
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
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {
    @Provides
    @Singleton
    fun provideApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        api: ApiService,
        application: Application
    ): PokemonRepositoryImpl {
        return PokemonRepositoryImpl(
            PokemonRemoteDataSource(api),
            PokemonFileDataSource(application)
        )
    }
}
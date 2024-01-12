package com.example.pokedex2.dependencies

import com.example.pokedex2.model.api.IPokedexApi
import com.example.pokedex2.model.api.PokedexRepository
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
    fun provideApi(): IPokedexApi {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IPokedexApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: IPokedexApi): PokedexRepository {
        return PokedexRepository(api)
    }
}
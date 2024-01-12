package com.example.pokedex2.dependencies

import com.example.pokedex2.model.api.IPokedexApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideDB(): IPokedexApi
}
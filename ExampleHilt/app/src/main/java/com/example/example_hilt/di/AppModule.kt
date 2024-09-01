package com.example.example_hilt.di

import com.example.example_hilt.Adres
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAdres() : Adres {
        return Adres("Kadikoy / Istanbul")
    }
}
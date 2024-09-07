package com.example.kisileruygulamasihilt.di

import com.example.kisileruygulamasihilt.data.datasource.KisilerDataSource
import com.example.kisileruygulamasihilt.data.repo.KisilerRepository
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
    fun provideKisilerRepository(kds:KisilerDataSource) : KisilerRepository {
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource() : KisilerDataSource {
        return KisilerDataSource()
    }
}
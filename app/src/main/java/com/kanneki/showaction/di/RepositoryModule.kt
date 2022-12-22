package com.kanneki.showaction.di

import com.kanneki.showaction.data.repository.ShowActionRepositoryImpl
import com.kanneki.showaction.domain.repository.ShowActionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindShowActionRepository(
        showActionRepositoryImpl: ShowActionRepositoryImpl
    ): ShowActionRepository
}
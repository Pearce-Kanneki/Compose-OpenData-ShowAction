package com.kanneki.showaction.di

import com.kanneki.showaction.data.remote.ShowActionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShowActionApi(): ShowActionApi {
        return Retrofit.Builder()
            .baseUrl("https://cloud.culture.tw/frontsite/trans/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
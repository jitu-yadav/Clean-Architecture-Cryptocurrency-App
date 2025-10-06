package com.stupid.cryptocurrencyapp.di

import com.stupid.cryptocurrencyapp.common.Constant.BASE_URL
import com.stupid.cryptocurrencyapp.data.remote.CoinPaprikaAPI
import com.stupid.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.stupid.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Here you can provide your network-related dependencies like Retrofit, OkHttpClient, etc.
    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI) : CoinRepository {
        return CoinRepositoryImpl(api)
    }
}
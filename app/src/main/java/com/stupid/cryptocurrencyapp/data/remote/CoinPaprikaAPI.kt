package com.stupid.cryptocurrencyapp.data.remote

import com.stupid.cryptocurrencyapp.data.remote.dto.CoinDetailsDto
import com.stupid.cryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto
}
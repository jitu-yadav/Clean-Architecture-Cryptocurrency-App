package com.stupid.cryptocurrencyapp.domain.repository

import com.stupid.cryptocurrencyapp.data.remote.dto.CoinDetailsDto
import com.stupid.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailsDto
}
package com.stupid.cryptocurrencyapp.data.repository

import com.stupid.cryptocurrencyapp.data.remote.CoinPaprikaAPI
import com.stupid.cryptocurrencyapp.data.remote.dto.CoinDetailsDto
import com.stupid.cryptocurrencyapp.data.remote.dto.CoinDto
import com.stupid.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(val api: CoinPaprikaAPI): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }
}
package com.stupid.cryptocurrencyapp.domain.use_cases.get_coins

import com.stupid.cryptocurrencyapp.common.Error
import com.stupid.cryptocurrencyapp.common.Loading
import com.stupid.cryptocurrencyapp.common.Resource
import com.stupid.cryptocurrencyapp.common.Success
import com.stupid.cryptocurrencyapp.data.remote.dto.toCoin
import com.stupid.cryptocurrencyapp.domain.model.Coin
import com.stupid.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(val repo : CoinRepository) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Loading())
            val coins = repo.getCoins().map { it.toCoin() }
            emit(Success(coins))
        } catch (ex: HttpException) {
            emit(Error(ex.localizedMessage?: "An unexpected error occurred"))
        } catch (ex: IOException) {
            emit(Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
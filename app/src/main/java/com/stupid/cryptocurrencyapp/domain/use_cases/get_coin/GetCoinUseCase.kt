package com.stupid.cryptocurrencyapp.domain.use_cases.get_coin

import com.stupid.cryptocurrencyapp.common.Error
import com.stupid.cryptocurrencyapp.common.Loading
import com.stupid.cryptocurrencyapp.common.Resource
import com.stupid.cryptocurrencyapp.common.Success
import com.stupid.cryptocurrencyapp.data.remote.dto.toCoinDetails
import com.stupid.cryptocurrencyapp.domain.model.CoinDetails
import com.stupid.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(val repo: CoinRepository) {

    operator fun invoke(coinId: String) : Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Loading())
            val coin = repo.getCoinById(coinId).toCoinDetails()
            emit(Success(coin))
        } catch (ex: HttpException) {
            emit(Error(ex.localizedMessage?: "An unexpected error occurred"))
        } catch (ex: IOException) {
            emit(Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
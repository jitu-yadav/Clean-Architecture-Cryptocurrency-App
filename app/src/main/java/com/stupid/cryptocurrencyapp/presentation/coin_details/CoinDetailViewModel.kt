package com.stupid.cryptocurrencyapp.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stupid.cryptocurrencyapp.common.Constant.COIN_ID
import com.stupid.cryptocurrencyapp.common.Loading
import com.stupid.cryptocurrencyapp.common.Success
import com.stupid.cryptocurrencyapp.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val getCoinUseCase: GetCoinUseCase,
    val saveStateHandle: SavedStateHandle) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        saveStateHandle.get<String>(COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
                is Success -> {
                    _state.value = CoinDetailsState(coinDetails = result.data)
                }
                else -> {
                    _state.value = CoinDetailsState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}
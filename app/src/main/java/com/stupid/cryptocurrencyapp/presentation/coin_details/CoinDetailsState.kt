package com.stupid.cryptocurrencyapp.presentation.coin_details

import com.stupid.cryptocurrencyapp.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error:String = ""
)
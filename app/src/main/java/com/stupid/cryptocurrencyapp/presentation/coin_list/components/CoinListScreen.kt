package com.stupid.cryptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.stupid.cryptocurrencyapp.presentation.Screen
import com.stupid.cryptocurrencyapp.presentation.coin_list.CoinListViewModel

@Composable
fun CoinList(
    navController: NavController,
    coinListViewModel: CoinListViewModel = hiltViewModel()
) {
    val state = coinListViewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(state.coins) { coin ->
                CoinListItem(coin) {
                    navController.navigate(Screen.CoinDetailsScreen.route + "/${coin.id}")
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(text = state.error,
                fontSize = 24.sp,
                modifier = Modifier.fillMaxSize()
                    .align(Alignment.Center)
                    .padding(horizontal = 20.dp))
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
package com.stupid.cryptocurrencyapp.presentation.coin_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.stupid.cryptocurrencyapp.presentation.coin_details.CoinDetailViewModel


@Composable
fun CoinDetailsScreen(
    coinDetailViewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = coinDetailViewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coinDetails?.let { coinDetails ->
            LazyColumn(modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)) {
                item {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row {
                            Text(
                                text = "${coinDetails.rank}. ${coinDetails.name} (${coinDetails.symbol})",
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.weight(8f)
                            )

                            Text(
                                text = if (coinDetails.isActive) "Active" else "Inactive",
                                color = if (coinDetails.isActive) Color.Green else Color.Red,
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier.weight(2f)
                                    .align(Alignment.CenterVertically),
                            )
                        }

                        Spacer(modifier = Modifier.height(28.dp))

                        HtmlTextview(html = coinDetails.description)

                        Spacer(modifier = Modifier.height(28.dp))

                        Text(text = "Tags", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))

                        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                                .padding(8.dp)) {
                            coinDetails.tags.forEach { tag->
                                CoinTag(tag = tag.name)
                             }
                        }

                        Spacer(modifier = Modifier.height(28.dp))
                        if (coinDetails.team.isNotEmpty()) {
                            Text(
                                text = "Team Members",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }

                items(coinDetails.team) { member ->
                    TeamListItem(teamMember = member)
                    HorizontalDivider(modifier = Modifier, 0.5.dp, Color.LightGray)
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
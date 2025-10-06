package com.stupid.cryptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stupid.cryptocurrencyapp.domain.model.Coin

@Composable
fun CoinListItem(coin: Coin, onItemClick: (Coin) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()
        .clickable{onItemClick(coin) }
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.weight(8f))
        Text(text = if (coin.isActive) "Active" else "Inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            fontSize = 14.sp,
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.CenterVertically).weight(2f))
    }
}
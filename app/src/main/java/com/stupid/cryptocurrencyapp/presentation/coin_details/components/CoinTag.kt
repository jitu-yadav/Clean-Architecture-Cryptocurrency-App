package com.stupid.cryptocurrencyapp.presentation.coin_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CoinTag(tag: String) {

    Box(modifier = Modifier
        .border(width = 1.dp,
            color = Color.Green,
            shape = RoundedCornerShape(100.dp))
        .padding(8.dp)) {
        Text(text = tag,
            fontSize = 14.sp,
            color = Color.Green)
    }
}

@Preview(name = "Tag", showBackground = true)
@Composable
fun PreviewCoinTag() {
    CoinTag(tag = "Bitcoin")
}
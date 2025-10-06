package com.stupid.cryptocurrencyapp.presentation.coin_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stupid.cryptocurrencyapp.data.remote.dto.TeamMember

@Composable
fun TeamListItem(teamMember: TeamMember) {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        Text(text = teamMember.name,
            fontSize = 16.sp)
        Text(text = teamMember.position,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 2.dp),
            fontStyle = FontStyle.Italic)
    }
}
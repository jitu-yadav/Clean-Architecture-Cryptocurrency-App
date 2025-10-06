package com.stupid.cryptocurrencyapp.domain.model

import com.stupid.cryptocurrencyapp.data.remote.dto.Tag
import com.stupid.cryptocurrencyapp.data.remote.dto.TeamMember

data class CoinDetails(
    val id: String,
    val description: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>)
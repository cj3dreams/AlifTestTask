package com.cj3dreams.domain.model

data class Data(
    val endDate: String,
    val icon: String,
    val loginRequired: Boolean,
    val name: String,
    val objType: String,
    val startDate: String,
    val url: String,
    val venue: Venue
)
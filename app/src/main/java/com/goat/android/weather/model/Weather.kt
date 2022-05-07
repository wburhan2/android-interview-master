package com.goat.android.weather.model

import com.squareup.moshi.JsonClass

/**
 * TODO: Include file description and usage here
 */
@JsonClass(generateAdapter = true)
data class Weather(
    val id: Int,
    val main: String = "",
    val description: String = "",
    val icon: String = ""
)

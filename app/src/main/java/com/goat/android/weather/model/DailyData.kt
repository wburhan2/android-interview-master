package com.goat.android.weather.model

import com.squareup.moshi.JsonClass

/**
 * TODO: Include file description and usage here
 */
@JsonClass(generateAdapter = true)
data class DailyData(
    val temp: Temp,
)

@JsonClass(generateAdapter = true)
data class Temp (
    val min: Float = 0.0f,
    val max: Float = 0.0f
)
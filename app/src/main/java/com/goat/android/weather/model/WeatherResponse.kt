package com.goat.android.weather.model

import com.squareup.moshi.JsonClass

/**
 * TODO: Include file description and usage here
 */
@JsonClass(generateAdapter = true)
data class WeatherResponse(
    val lat: Float = 0.0f,
    val lon: Float = 0.0f,
    val current: Current,
    val hourly: List<WeatherData>,
    val daily: List<DailyData>
)

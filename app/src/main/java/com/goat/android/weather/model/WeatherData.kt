package com.goat.android.weather.model

import com.squareup.moshi.JsonClass

/**
 * TODO: Include file description and usage here
 */
@JsonClass(generateAdapter = true)
data class WeatherData(
    val temp: Float,
    val feels_like: Float,
    val weather: List<Weather> = mutableListOf()
)

package com.goat.android.weather.model

import com.squareup.moshi.JsonClass

/**
 * TODO: Include file description and usage here
 */
@JsonClass(generateAdapter = true)
data class Current(
    val dt: Long = 0,
    val temp: Float = 0.0f,
    val feels_like: Float = 0.0f,
    val weather: List<Weather> = mutableListOf()
)

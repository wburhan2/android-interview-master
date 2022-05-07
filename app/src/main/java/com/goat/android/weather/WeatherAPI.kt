package com.goat.android.weather

import com.goat.android.weather.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.Callable

/**
 * TODO: Include file description and usage here
 */
interface WeatherAPI {

    @GET("data/2.5/onecall")
    fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String
    ): Call<WeatherResponse>
}
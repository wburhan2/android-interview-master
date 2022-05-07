package com.goat.android.weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goat.android.weather.model.WeatherResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * TODO: Include file description and usage here
 */
class WeatherViewModel: ViewModel() {

    lateinit var okHttpClient: OkHttpClient
    lateinit var weatherApi: WeatherAPI

    val dateTime = MutableLiveData<String>()
    val currentLo = MutableLiveData<String>()
    val currentHi = MutableLiveData<String>()


    fun getWeatherData(lat: Double, lon: Double, apiKey: String) {
        getApi().getWeatherData(lat, lon, apiKey)
            .enqueue(object: Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    if (response.isSuccessful) {
//                        callback.onSuccess(response.body()!!)
                        val weather = response.body()!!
                        val current = weather.current
                        val daily = weather.daily
                        val dt = Date(current.dt)
                        dateTime.postValue(dt.toString())
                        val currLo = daily[0].temp.min
                        val currHi = daily[0].temp.max

                        currentLo.postValue("${currLo}F")
                        currentHi.postValue("${currHi}F")
                    } else {
                        //log
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
//                    callback.onFailure(t)
                    Log.e("TAG", t.message!!)
                }

            })
    }




    private fun getApi(): WeatherAPI {
        if (!this::okHttpClient.isInitialized) {
            okHttpClient = OkHttpClient().newBuilder()
                .callTimeout(1, TimeUnit.MINUTES)
                .build()
        }
        if (!this::weatherApi.isInitialized) {
            weatherApi = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherAPI::class.java)
        }
        return weatherApi
    }
}
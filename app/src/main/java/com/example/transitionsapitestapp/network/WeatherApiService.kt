package com.example.transitionsapitestapp.network

import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherApiService {

    @GET("/data/2.5/weather")
    fun getWeather(
        @Query("appid") apiKey: String,
        @Query("q") city: String
    ): Single<WeatherClass>
}
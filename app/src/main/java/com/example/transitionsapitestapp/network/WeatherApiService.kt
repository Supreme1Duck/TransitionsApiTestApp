package com.example.transitionsapitestapp.network

import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherApiService {

    @GET("/weather")
    fun getWeather(
        @Header("appid") apiKey: String,
        @Query("id") city: String,
    ): Single<WeatherClass>
}
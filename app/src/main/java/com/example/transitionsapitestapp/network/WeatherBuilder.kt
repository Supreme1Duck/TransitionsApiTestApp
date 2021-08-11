package com.example.transitionsapitestapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherBuilder{
    val retrofitInstance = Retrofit.Builder()
        .baseUrl("api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
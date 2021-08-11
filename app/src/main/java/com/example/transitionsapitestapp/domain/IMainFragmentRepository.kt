package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass

interface IMainFragmentRepository {
    fun getWeather(city: String): WeatherClass
}
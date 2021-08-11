package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass

interface IWeatherUseCase {
    fun execute(city: String): WeatherClass
}
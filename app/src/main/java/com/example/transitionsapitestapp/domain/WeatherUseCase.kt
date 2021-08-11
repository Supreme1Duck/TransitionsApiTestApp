package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass

class WeatherUseCase(val repository: IMainFragmentRepository) : IWeatherUseCase{
    override fun execute(city: String): WeatherClass {
        return repository.getWeather(city)
    }
}
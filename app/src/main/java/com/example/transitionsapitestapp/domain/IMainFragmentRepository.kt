package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass
import io.reactivex.rxjava3.core.Single

interface IMainFragmentRepository {
    fun getWeather(city: String): Single<WeatherClass>
}
package com.example.transitionsapitestapp.data.fragment

import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass
import com.example.transitionsapitestapp.domain.IMainFragmentRepository
import com.example.transitionsapitestapp.network.WeatherApiService
import com.example.transitionsapitestapp.network.WeatherBuilder
import com.example.transitionsapitestapp.utils.Constants
import io.reactivex.rxjava3.core.Single

class MainFragmentRepository : IMainFragmentRepository {

    override fun getWeather(city: String): Single<WeatherClass> {
        val service = WeatherBuilder.retrofitInstance.create(WeatherApiService::class.java)
        return service.getWeather(city, Constants.API_KEY)
    }
}
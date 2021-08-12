package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherUseCase(private val repository: IMainFragmentRepository) : IWeatherUseCase{

    override fun execute(city: String): Single<WeatherClass> {
        return repository.getWeather(city)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
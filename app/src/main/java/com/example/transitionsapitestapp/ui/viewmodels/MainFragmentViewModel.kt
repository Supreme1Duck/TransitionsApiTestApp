package com.example.transitionsapitestapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass
import com.example.transitionsapitestapp.domain.IWeatherUseCase

class MainFragmentViewModel(
    val useCase: IWeatherUseCase
) : ViewModel() {

    private val _liveData = MutableLiveData<WeatherClass>()
    val liveData: LiveData<WeatherClass> = _liveData

    fun getWeather(name: String){
        _liveData.value = useCase.execute(name)
    }
}
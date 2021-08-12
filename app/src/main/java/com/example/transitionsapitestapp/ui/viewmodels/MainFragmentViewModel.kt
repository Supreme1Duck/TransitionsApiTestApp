package com.example.transitionsapitestapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transitionsapitestapp.data.fragment.weather.WeatherClass
import com.example.transitionsapitestapp.domain.IWeatherUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainFragmentViewModel (
    val useCase: IWeatherUseCase
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    private val _liveData = MutableLiveData<WeatherClass>()
    val liveData: LiveData<WeatherClass> = _liveData

    fun getWeather(name: String) {
        disposable.add(
            useCase.execute(name)
                .subscribe { it ->
                    _liveData.value = it
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
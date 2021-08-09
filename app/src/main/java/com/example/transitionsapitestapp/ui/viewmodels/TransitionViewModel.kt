package com.example.transitionsapitestapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transitionsapitestapp.domain.IUseCase

class TransitionViewModel(
    private val useCase: IUseCase,
) : ViewModel() {

    private val _liveData = MutableLiveData<String>()
    val liveData : LiveData<String> = _liveData

    fun getData(name: String){
        _liveData.value = useCase.execute(name)
    }
}
package com.example.transitionsapitestapp.ui.fragments.chosefragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity
import com.example.transitionsapitestapp.domain.ICatsUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable

class CatsViewModel(
    val useCase: ICatsUseCase
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    private val _liveData = MutableLiveData<CatsEntity>()
    val liveData: LiveData<CatsEntity> = _liveData
    private val _favouritesLiveData = MutableLiveData<CatsEntity>()
    val favouritesLiveData: LiveData<CatsEntity> = _favouritesLiveData

    fun getData(limit: Int) {
        val pair = useCase.execute(limit)
        pair.first.subscribe { list ->
            _liveData.value = list
        }
        pair.second?.subscribe { list ->
            _favouritesLiveData.value = list
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}
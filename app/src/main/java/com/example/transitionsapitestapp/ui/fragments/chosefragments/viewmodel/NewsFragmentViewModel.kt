package com.example.transitionsapitestapp.ui.fragments.chosefragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.domain.INewsUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable

class NewsFragmentViewModel(
    private val useCase: INewsUseCase
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    private val _liveData = MutableLiveData<News>()
    val liveData: LiveData<News> = _liveData

    init {
        getNews()
    }

    private fun getNews() {
        disposable.add(
            useCase.execute("Bitcoin")
                .first.subscribe { it ->
                    _liveData.value = it
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}
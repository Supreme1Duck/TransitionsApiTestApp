package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CatsUseCase(
    private val repository: ICatsRepository
) : ICatsUseCase {
    override fun execute(limit: Int): Pair<Single<CatsEntity>, Single<CatsEntity>?> {
        return Pair(
            repository.getCats(limit)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()),
            repository.getFavourites()
                ?.subscribeOn(Schedulers.computation())
                ?.observeOn(AndroidSchedulers.mainThread())
        )
    }
}
package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity
import io.reactivex.rxjava3.core.Single

interface ICatsUseCase {
    fun execute(limit: Int) : Pair<Single<CatsEntity>, Single<CatsEntity>?>
}
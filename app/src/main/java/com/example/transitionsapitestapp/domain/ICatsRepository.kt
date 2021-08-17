package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity
import io.reactivex.rxjava3.core.Single

interface ICatsRepository {

    fun getCats(limit: Int): Single<CatsEntity>

    fun getFavourites(): Single<CatsEntity>?
}
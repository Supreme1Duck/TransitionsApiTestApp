package com.example.transitionsapitestapp.data.fragment.cats.repository

import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity
import com.example.transitionsapitestapp.domain.ICatsRepository
import com.example.transitionsapitestapp.network.CatsApiService
import com.example.transitionsapitestapp.utils.Constants
import io.reactivex.rxjava3.core.Single

class CatsRepository : ICatsRepository {

    override fun getCats(limit: Int): Single<CatsEntity> {
        val service = CatsApiService.retrofit.create(CatsApiService::class.java)
        return service.getCats(Constants.CATS_API_KEY, limit)
    }

    override fun getFavourites(): Single<CatsEntity>? {
        TODO("Not yet implemented")
    }
}
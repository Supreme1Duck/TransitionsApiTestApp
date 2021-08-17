package com.example.transitionsapitestapp.network

import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatsApiService {

    companion object Builder {
        val retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.thecatapi.com/")
            .build()
    }

    @GET("v1/images/search")
    fun getCats(
        @Header("x-api-key") api_key: String,
        @Query("limit") limit: Int
    ): Single<CatsEntity>
}
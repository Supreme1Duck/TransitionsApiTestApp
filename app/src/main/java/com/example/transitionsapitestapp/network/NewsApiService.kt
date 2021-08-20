package com.example.transitionsapitestapp.network

import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.data.fragment.news.topheadlines.TopHeadlines
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything")
    fun getNews(
        @Header("X-Api-key") apiKey: String,
        @Query("q") target: String,
        @Query("sortBy") sortBy: String,
        @Query("from") dateFrom: String,
        @Query("to") dateTo: String,
        @Query("language") language: String,
        @Query("pageSize") pageSize: Int
    ): Single<News>

    @GET("/v2/top-headlines")
    fun getHeadlines(
        @Header("X-Api-key") apiKey: String,
        @Query("country") country: String = "ru",
        @Query("category") category: String = "business",
        @Query("q") target: String = ""
    ): Single<TopHeadlines>

    companion object Builder{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}
package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.data.fragment.news.topheadlines.TopHeadlines
import io.reactivex.rxjava3.core.Single

interface INewsUseCase {

    fun execute(
        target: String = "Bitcoin",
        sortBy: String = "",
        dateFrom: String = "",
        dateTo: String = "",
        language: String = "ru",
        country: String = "ru",
        category: String = "",
    ): Pair<Single<News>, Single<TopHeadlines>>

    fun getNews(
        target: String,
        sortBy: String = "popularity",
        dateFrom: String = "",
        dateTo: String = "",
        language: String = "ru"
    ): Single<News>

    fun getTopHeadlines(
        country: String = "ru",
        category: String = "",
        target: String
    ): Single<TopHeadlines>
}
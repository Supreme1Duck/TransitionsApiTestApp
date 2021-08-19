package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.data.fragment.news.topheadlines.TopHeadlines
import io.reactivex.rxjava3.core.Single

interface INewsUseCase {

    fun execute(
        target: String,
        popularity: String,
        dateFrom: String,
        dateTo: String,
        language: String,
        country: String,
        category: String,
    ): Pair<Single<News>, Single<TopHeadlines>>

    fun getNews(
        target: String,
        popularity: String,
        dateFrom: String,
        dateTo: String,
        language: String
    ): Single<News>

    fun getTopHeadlines(
        country: String,
        category: String,
        target: String
    ): Single<TopHeadlines>
}
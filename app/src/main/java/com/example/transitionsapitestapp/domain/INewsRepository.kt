package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.data.fragment.news.topheadlines.TopHeadlines
import io.reactivex.rxjava3.core.Single

interface INewsRepository {

    fun getNews(
        target: String,
        popularity: String,
        dateFrom: String,
        dateTo: String,
        language: String
    ): Single<News>

    fun getHeadlines(
        country: String,
        category: String,
        target: String
    ): Single<TopHeadlines>
}
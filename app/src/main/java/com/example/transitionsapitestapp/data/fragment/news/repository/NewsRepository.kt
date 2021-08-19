package com.example.transitionsapitestapp.data.fragment.news.repository

import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.data.fragment.news.topheadlines.TopHeadlines
import com.example.transitionsapitestapp.domain.INewsRepository
import com.example.transitionsapitestapp.network.NewsApiService
import com.example.transitionsapitestapp.network.WeatherBuilder
import com.example.transitionsapitestapp.utils.Constants
import io.reactivex.rxjava3.core.Single

class NewsRepository : INewsRepository {

    private val service = WeatherBuilder.retrofitInstance.create(NewsApiService::class.java)

    override fun getNews(
        target: String,
        popularity: String,
        dateFrom: String,
        dateTo: String,
        language: String
    ): Single<News> {
        return service.getNews(
            Constants.NEWS_API_KEY,
            target,
            popularity,
            dateFrom,
            dateTo,
            language
        )
    }

    override fun getHeadlines(
        country: String,
        category: String,
        target: String
    ): Single<TopHeadlines> {
        return service.getHeadlines(
            Constants.NEWS_API_KEY,
            country,
            category,
            target
        )
    }

}
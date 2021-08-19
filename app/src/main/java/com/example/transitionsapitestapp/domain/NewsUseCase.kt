package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.data.fragment.news.topheadlines.TopHeadlines
import io.reactivex.rxjava3.core.Single

class NewsUseCase(
    private val repository: INewsRepository
) : INewsUseCase {

    override fun execute(
        target: String,
        popularity: String,
        dateFrom: String,
        dateTo: String,
        language: String,
        country: String,
        category: String,
    ): Pair<Single<News>, Single<TopHeadlines>> {
        return Pair(
            repository.getNews(target, popularity, dateFrom, dateTo, language),
            repository.getHeadlines(country, category, target)
        )
    }

    override fun getNews(
        target: String,
        popularity: String,
        dateFrom: String,
        dateTo: String,
        language: String
    ): Single<News> {
        return repository.getNews(
            target,
            popularity,
            dateFrom,
            dateTo,
            language
        )
    }

    override fun getTopHeadlines(
        country: String,
        category: String,
        target: String
    ): Single<TopHeadlines> {
        return repository.getHeadlines(country, category, target)
    }
}
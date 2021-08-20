package com.example.transitionsapitestapp.domain

import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.data.fragment.news.topheadlines.TopHeadlines
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsUseCase(
    private val repository: INewsRepository
) : INewsUseCase {

    override fun execute(
        target: String,
        sortBy: String,
        dateFrom: String,
        dateTo: String,
        language: String,
        country: String,
        category: String,
    ): Pair<Single<News>, Single<TopHeadlines>> {
        return Pair(
            repository.getNews(target, sortBy, dateFrom, dateTo, language)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()),
            repository.getHeadlines(country, category, target)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
        )
    }

    override fun getNews(
        target: String,
        sortBy: String,
        dateFrom: String,
        dateTo: String,
        language: String
    ): Single<News> {
        return repository.getNews(
            target,
            sortBy,
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
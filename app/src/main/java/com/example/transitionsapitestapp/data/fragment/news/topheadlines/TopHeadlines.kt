package com.example.transitionsapitestapp.data.fragment.news.topheadlines

data class TopHeadlines(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
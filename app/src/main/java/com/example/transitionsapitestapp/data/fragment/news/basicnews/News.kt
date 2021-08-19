package com.example.transitionsapitestapp.data.fragment.news.basicnews

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
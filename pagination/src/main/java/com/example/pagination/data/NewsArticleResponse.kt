package com.example.pagination.data

data class NewsArticleResponse(
    val articles: List<NewsArticle>,
    val status: String,
    val totalResult: Int
)

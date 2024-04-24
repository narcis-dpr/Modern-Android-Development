package com.example.pagination.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.pagination.service.NewsApiService
import com.example.pagination.service.pager.NewsArticlePagingSource
import com.example.pagination.utile.Constants.PAGE_SIZE
import javax.inject.Inject

class NewsArticleRepository @Inject constructor(
    private val newsApiService: NewsApiService
) {
    fun getNewsArticle() = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
        ),
        pagingSourceFactory = {
            NewsArticlePagingSource(newsApiService)
        }
    ).flow
}
package com.example.pagination.di

import com.example.pagination.repository.NewsArticleRepository
import com.example.pagination.service.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideNewsRepository(newsApiService: NewsApiService): NewsArticleRepository =
        NewsArticleRepository(newsApiService)
}
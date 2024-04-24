package com.example.pagination.service

import com.example.pagination.data.NewsArticleResponse
import com.example.pagination.utile.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("everything?q=apple&sortBy=popularity&apiKey${API_KEY}=&pageSize=20")
    suspend fun getNews(
        @Query("page") page: Int
    ): NewsArticleResponse
}
package com.example.pagination.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagination.data.NewsArticle
import com.example.pagination.repository.NewsArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NewsArticleViewModel @Inject constructor(
    private val repository: NewsArticleRepository
): ViewModel() {
    fun getNewsArticle(): Flow<PagingData<NewsArticle>> =
        repository.getNewsArticle().cachedIn(viewModelScope)
}
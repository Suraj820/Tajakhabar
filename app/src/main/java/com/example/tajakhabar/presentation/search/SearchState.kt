package com.example.tajakhabar.presentation.search

import androidx.paging.PagingData
import com.example.tajakhabar.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery:String="",
    val articles: Flow<PagingData<Article>>? = null
)
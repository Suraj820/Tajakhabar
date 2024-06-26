package com.example.tajakhabar.domain.repository

import androidx.paging.PagingData
import com.example.tajakhabar.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources:List<String>):Flow<PagingData<Article>>
}
package com.example.tajakhabar.domain.repository

import androidx.paging.PagingData
import com.example.tajakhabar.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources:List<String>):Flow<PagingData<Article>>

    fun searchNews(searchQuery:String ,sources:List<String>):Flow<PagingData<Article>>

    suspend fun upsertArticle(article: Article)
    suspend fun deleteArticle(article: Article)
    fun selectedArticles():Flow<List<Article>>
    suspend fun selectedArticle(url:String):Article?

}
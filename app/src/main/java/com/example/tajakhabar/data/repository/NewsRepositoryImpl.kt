package com.example.tajakhabar.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tajakhabar.data.remote.NewsAPI
import com.example.tajakhabar.data.remote.NewsPagingSource
import com.example.tajakhabar.data.remote.SearchNewsPagingSource
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(private val newsApi: NewsAPI):NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
       return Pager(
           config = PagingConfig(pageSize = 10),
           pagingSourceFactory = {
               NewsPagingSource(
                   newsApi,sources.joinToString(",")
               )
           }
       ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {

        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery, newsAPI = newsApi, sources = sources.joinToString(",")
                )
            }
        ).flow
    }
}
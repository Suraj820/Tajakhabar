package com.example.tajakhabar.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tajakhabar.data.local.NewsDao
import com.example.tajakhabar.data.remote.NewsAPI
import com.example.tajakhabar.data.remote.NewsPagingSource
import com.example.tajakhabar.data.remote.SearchNewsPagingSource
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class NewsRepositoryImp(
    private val newsApi: NewsAPI,
    private val newsDao : NewsDao
):NewsRepository {
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

    override suspend fun upsertArticle(article: Article) {
        newsDao.insert(article)
    }

    override suspend fun deleteArticle(article: Article) {
       newsDao.delete(article)
    }

    override fun selectedArticles(): Flow<List<Article>> {
       return newsDao.getArticles()
    }

    override suspend fun selectedArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }
}
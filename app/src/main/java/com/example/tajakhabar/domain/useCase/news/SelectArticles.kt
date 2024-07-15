package com.example.tajakhabar.domain.useCase.news

import com.example.tajakhabar.data.local.NewsDao
import com.example.tajakhabar.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {
     operator fun invoke():Flow<List<Article>>{
        return newsDao.getArticles()
    }
}
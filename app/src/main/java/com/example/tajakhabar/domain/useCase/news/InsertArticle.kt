package com.example.tajakhabar.domain.useCase.news

import com.example.tajakhabar.data.local.NewsDao
import com.example.tajakhabar.domain.model.Article

class InsertArticle(
    private val dao :NewsDao
) {
    suspend operator fun invoke(article: Article){
        dao.insert(article)
    }
}
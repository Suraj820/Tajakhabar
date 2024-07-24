package com.example.tajakhabar.domain.useCase.news

import com.example.tajakhabar.data.local.NewsDao
import com.example.tajakhabar.domain.model.Article

class SelectArticle (
    private val dao : NewsDao
) {
    suspend operator fun invoke(url: String):Article?{
       return dao.getArticle(url)
    }
}
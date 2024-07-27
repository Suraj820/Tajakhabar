package com.example.tajakhabar.domain.useCase.news

import com.example.tajakhabar.data.local.NewsDao
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.domain.repository.NewsRepository

class DeleteArticle (
    private val  newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}
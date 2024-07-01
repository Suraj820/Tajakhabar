package com.example.tajakhabar.domain.useCase.news

import androidx.paging.PagingData
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(source:List<String>): Flow<PagingData<Article>> {
        return  newsRepository.getNews(source)
    }
}
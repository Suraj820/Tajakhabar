package com.example.tajakhabar.data.remote.dto

import com.example.tajakhabar.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
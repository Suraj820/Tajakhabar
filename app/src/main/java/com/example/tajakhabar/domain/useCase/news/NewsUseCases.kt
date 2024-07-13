package com.example.tajakhabar.domain.useCase.news



data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val insertArticle: InsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles
)
